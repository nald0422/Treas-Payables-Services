package tmc.tres.payables.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;

import tmc.tres.payables.dao.Disbursement_Repo;
import tmc.tres.payables.dao.Payables_Repo;
import tmc.tres.payables.dao.Payment_Repo;
import tmc.tres.payables.model.Disbursement;
import tmc.tres.payables.model.Payables;
import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Release;
import tmc.tres.payables.model.Status;

@RestController
public class DisbursementController {

	@Autowired
	Payment_Repo payment_repo;

	@Autowired
	Disbursement_Repo disbursement_repo;

	@Autowired
	Payables_Repo payables_repo;

	@PostMapping(path = "/disburse")
	@ResponseBody
	public void addDisbursement(@RequestBody Disbursement disbursement) {
		Disbursement strDisbursement = new Disbursement();

		System.out.println("Disbursement : " + disbursement);

		List<PaymentRequest> paymentRequests = new ArrayList<>();

		boolean disbursementOperationSave = true;

		try {
			disbursement_repo.save(disbursement);
		} catch (Exception e) {
			e.printStackTrace();
			disbursementOperationSave = false;
		}

		// Checks if object is saved successfully
		if (disbursementOperationSave) {
			for (int i = 0; i < disbursement.getPaymentRequests().size(); i++) {
				Payables payable = new Payables();

				payable = payables_repo.findByPaymentRequest(disbursement.getPaymentRequests().get(i));

				// Update payable with disbursed requested payment
				payable.setDisbursement(disbursement);

				Status status = new Status();

				status.setStatusId(3);
				payable.setStatus(status);
				payables_repo.save(payable);

				disbursement.setPayables(payable);
				disbursement.setLastModified(LocalDateTime.now());
				disbursement_repo.save(disbursement);
			}

		} else {
			throw new MultipartException("Disbursement Error");
		}
	}

	@PutMapping(path = "/updateDisbursement/{opt}")
	@ResponseBody
	public void updateDisbursement(@RequestBody Disbursement disbursement, @PathVariable("opt") String operation) {

		Payables payable = payables_repo.findByDisbursement(disbursement).get(0);

		Status status = new Status();

		switch (operation) {
		case "void":

			if (payable.getStatus().getStatusId() == 10) {
				System.out.println("Existing cheque record with disbursement id : " + disbursement.getDisbursementId());
			} else {
				status.setStatusId(10);
				payable.setStatus(status);
			} 
			break;
		case "update":
			status.setStatusId(payable.getStatus().getStatusId());
			payable.setStatus(status);
			break;
		case "hold":
			status.setStatusId(8);
			payable.setStatus(status);
		break;
		case "forReleasing":
			status.setStatusId(2);
			payable.setStatus(status);
			break;
		}

//		payables_repo.save(payable);

		Boolean opPayable = true;

		try {
			payables_repo.save(payable);
		} catch (Exception e) {
			System.out.println("Error updating disbursement:" + disbursement.getDisbursementId() + " with error: "
					+ e.getMessage());
			opPayable = false;
		}

		if (opPayable == true) {
			// Set Disbursement's assigned Payable
			disbursement.setPayables(payable);
			disbursement.setLastModified(LocalDateTime.now());
			disbursement_repo.save(disbursement);
		} else {
			System.out.println("Failed Updating Payable, Please Review Updated Data of Disbursement.");
		}

	}

	@RequestMapping("/getDisbursement/{disbursementId}")
	@ResponseBody
	public Disbursement getPaymentRequest(@PathVariable("disbursementId") long disbursementId) {
		return disbursement_repo.findBydisbursementId(disbursementId);
	}

	@GetMapping(path = "/disbursements")
	@ResponseBody
	public List<Disbursement> getDisbursements() {
		return disbursement_repo.findAll();
	}

	@GetMapping(path = "/disbursements/entries")
	@ResponseBody
	public List<Disbursement> getPaymentRequestsByStatus() {
		List<Disbursement> disbursements = new ArrayList<>();
		List<Payables> payables = payables_repo.findByStatus_StatusId(3);

		for (Payables py : payables) {
			disbursements.add(py.getDisbursement());
		}

		return disbursements;
	}

}
