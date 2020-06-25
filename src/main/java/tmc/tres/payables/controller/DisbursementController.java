package tmc.tres.payables.controller;

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

	@PostMapping(path = "/addDisbursement/{paymentRequestNo}")
	@ResponseBody
	public void addDisbursement(@RequestBody Disbursement disbursement,
			@PathVariable("paymentRequestNo") long paymentRequestNo) {

		// Get PaymentRequest Entity based from client's payment request no.
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest = payment_repo.findBypaymentRequestNo(paymentRequestNo);

		Payables payable = new Payables();
		payable = payables_repo.findByPaymentRequest(paymentRequest);

		if (payable.getDisbursement() == null) {
			Disbursement strDisbursement = new Disbursement();
			strDisbursement = disbursement_repo.save(disbursement);

			// Checks if object is saved successfully
			if (disbursement_repo.findBydisbursementId(strDisbursement.getDisbursementId()) != null) {

				// Update payable with disbursed requested payment
				payable.setDisbursement(disbursement);

				Status status = new Status();
				status.setStatusId(3);
				payable.setStatus(status);

				Boolean opPayable = true;

				try {
					payables_repo.save(payable);
				} catch (Exception e) {
					System.out.println("Error updating disbursement:" + disbursement.getDisbursementId()
							+ " with error: " + e.getMessage());
					opPayable = false;
				}

				if (opPayable == true) {
					// Set Disbursement's assigned Payable
					disbursement.setPayables(payable);
					disbursement_repo.save(disbursement);
				} else {
					System.out.println("Failed Updating Payable, Please Review Updated Data of Disbursement.");
				}

			} else {
				throw new MultipartException("Disbursement Error");
			}

		} else {
			System.out.println("Payment Request has already disbursement record.");
		}
	}

	@PutMapping(path = "/updateDisbursement/{opt}")
	@ResponseBody
	public void updateDisbursement(@RequestBody Disbursement disbursement, @PathVariable("opt") String operation) {

		Payables payable = payables_repo.findByDisbursement(disbursement);

		switch (operation) {
		case "void":

			Status status = new Status();

			status.setStatusId(10);
			payable.setStatus(status);
			payables_repo.save(payable);

			break;
		default:
			System.out.println("Regular update with disbursement id : " + disbursement.getDisbursementId());
		}

		disbursement.setPayables(payable);
		disbursement_repo.save(disbursement);
	}

	@GetMapping(path = "/disbursements")
	@ResponseBody
	public List<Disbursement> getDisbursements() {
		return disbursement_repo.findAll();
	}

	@RequestMapping("/getDisbursement/{disbursementId}")
	@ResponseBody
	public Disbursement getPaymentRequest(@PathVariable("disbursementId") long disbursementId) {
		return disbursement_repo.findBydisbursementId(disbursementId);
	}

}
