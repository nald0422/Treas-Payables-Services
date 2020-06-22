package tmc.tres.payables.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Disbursement_Repo;
import tmc.tres.payables.dao.Payables_Repo;
import tmc.tres.payables.dao.Payment_Repo;
import tmc.tres.payables.dao.Release_Repo;
import tmc.tres.payables.model.Disbursement;
import tmc.tres.payables.model.Payables;
import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Release;

@RestController
public class PayablesController {

	@Autowired
	Payables_Repo payables_repo;

	@Autowired
	Payment_Repo payment_repo;

	@Autowired
	Disbursement_Repo disbursement_repo;

	@Autowired
	Release_Repo release_repo;

	@PostMapping(path = "/addPayables")
	@ResponseBody
	public void addPayables(@RequestBody Payables payables) {
		payables_repo.save(payables);
	}

	@PutMapping(path = "/updatePayable")
	@ResponseBody
	public void updatePaymentRequest(@RequestBody Payables payables) {
		payables_repo.save(payables);
	}

	@PutMapping(path = "/updatePayable/{status}")
	@ResponseBody
	public void updatePaymentRequest(@RequestBody Payables payables, @PathVariable("status") String status) {

		Payables strPayable = payables_repo.findBypayablesId(payables.getPayablesId());

		if (strPayable != null) {
			payables_repo.save(payables);
		} else {
			System.out.println("Payable with id : " + payables.getPayablesId() + " doesn't exist.");
		}

	}

	@GetMapping(path = "/payables")
	@ResponseBody
	public List<Payables> Payables() {
		return payables_repo.findAll();
	}

	@GetMapping(path = "/getPayable/{entity}/{entityId}")
	@ResponseBody
	public Payables getPayable(@PathVariable("entity") String entity, @PathVariable("entityId") long entityId) {
		Payables payable = new Payables();
		switch (entity) {
		case "payment":
			PaymentRequest paymentRequest = new PaymentRequest();

			paymentRequest = payment_repo.findBypaymentRequestNo(entityId);
			payable = payables_repo.findByPaymentRequest(paymentRequest);

			break;
		case "disbursement":
			Disbursement disbursement = new Disbursement();

			disbursement = disbursement_repo.findBydisbursementId(entityId);
			payable = payables_repo.findByDisbursement(disbursement);

			break;
		case "release":
			Release release = new Release();

			release = release_repo.findByreleaseId(entityId);
			payable = payables_repo.findByRelease(release);
			break;
		}
		return payable;
	}
	
	//Verify if release is either ongoing release transaction or no history of release transaction.
	@PostMapping(path="/verifyRelease")
	@ResponseBody
	public Boolean verifyRelease(@RequestBody Disbursement disbursement) {
		Payables payable = payables_repo.findByDisbursement(disbursement); 
		Release release = payable.getRelease();
		
		if(Objects.isNull(release)) {
			return true;
		} else {
			return false;
		}
	}
	
	@PostMapping(path="/verifyDisbursement")
	@ResponseBody
	public Boolean verifyDisbursement(@RequestBody PaymentRequest paymentRequest) {
		Payables payable = payables_repo.findByPaymentRequest(paymentRequest);
		Disbursement disbursement = payable.getDisbursement();
		
		if(Objects.isNull(disbursement)) {
			return true;
		} else {
			return false;
		}
	}

}
