package tmc.tres.payables.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Designation_Repo;
import tmc.tres.payables.dao.Expense_Repo;
import tmc.tres.payables.dao.Payment_Repo;
import tmc.tres.payables.dao.Section_Repo;
import tmc.tres.payables.model.Designation;
import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Status;

@RestController
public class PaymentRequestController {

	@Autowired
	Payment_Repo payment_repo;

	@PostMapping(path = "/addPaymentRequest")
	@ResponseBody
	public void addPaymentRequest(@RequestBody List<PaymentRequest> paymentRequests) {
		for (PaymentRequest pr : paymentRequests) {
			Status status = new Status();
			status.setStatusId(1);

			System.out.println("Payment Request : " + pr.toString());

			pr.setStatus(status);
			payment_repo.save(pr);
		}
	}

	@PutMapping(path = "/updatePaymentRequest")
	@ResponseBody
	public void updatePaymentRequest(@RequestBody PaymentRequest paymentRequest) {
		payment_repo.save(paymentRequest);
	}

	@PutMapping(path = "/updatePaymentRequest/{paymentRequestNo}/{status}")
	@ResponseBody
	public void updatePaymentRequest(@PathVariable("paymentRequestNo") long paymentRequestNo,
			@PathVariable("status") String status) {
		payment_repo.setStatusForPaymentRequest(status, paymentRequestNo);
	}

	@RequestMapping("/getPaymentRequest/{paymentRequestNo}")
	@ResponseBody
	public PaymentRequest getPaymentRequest(@PathVariable("paymentRequestNo") long paymentRequestNo) {
		return payment_repo.findBypaymentRequestNo(paymentRequestNo);
	}

	@GetMapping(path = "/paymentRequests")
	@ResponseBody
	public List<PaymentRequest> getPaymentRequests() {
		return payment_repo.findAll();
	}
}
