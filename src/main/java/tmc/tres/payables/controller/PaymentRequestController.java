package tmc.tres.payables.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Designation_Repo;
import tmc.tres.payables.dao.Expense_Repo;
import tmc.tres.payables.dao.Payment_Repo;
import tmc.tres.payables.dao.Section_Repo;
import tmc.tres.payables.model.Designation;
import tmc.tres.payables.model.PaymentRequest;

@RestController
public class PaymentRequestController {
	
	@Autowired
	Payment_Repo payment_repo;
	
	@Autowired
	Expense_Repo expense_repo;
	
	@Autowired
	Section_Repo section_repo;
	
	@Autowired
	Designation_Repo designation_repo;
	
	@PostMapping(path="/addPaymentRequest")
	@ResponseBody
	public void addPaymentRequest(@RequestBody List<PaymentRequest> paymentRequests) {
		for(PaymentRequest pr: paymentRequests) {
			System.out.println("Payment Request : " + pr.toString());
			payment_repo.save(pr);
		}
	}
	
	@PutMapping(path="/updatePaymentRequest")
	@ResponseBody
	public void updatePaymentRequest(@RequestBody PaymentRequest paymentRequest) {
		payment_repo.save(paymentRequest);
	}
	
	@GetMapping(path="/paymentRequests")
	@ResponseBody
	public List<PaymentRequest> getPaymentRequests() {
		return payment_repo.findAll();
	}
}
