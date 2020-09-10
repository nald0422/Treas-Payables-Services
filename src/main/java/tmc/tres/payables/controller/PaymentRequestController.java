package tmc.tres.payables.controller;

import java.util.ArrayList;
import java.util.Calendar;
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

import tmc.tres.payables.dao.Payables_Repo;
import tmc.tres.payables.dao.Payment_Repo;
import tmc.tres.payables.dao.Status_Repo;
import tmc.tres.payables.model.Payables;
import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Status;

@RestController
public class PaymentRequestController {

	@Autowired
	Payment_Repo payment_repo;

	@Autowired
	Payables_Repo payables_repo;

	@Autowired
	Status_Repo status_repo;

	@PostMapping(path = "/addPaymentRequest")
	@ResponseBody
	public void addPaymentRequest(@RequestBody List<PaymentRequest> paymentRequests) {
		for (PaymentRequest pr : paymentRequests) {
			pr.setLastModified(Calendar.getInstance().getTime());
			PaymentRequest pr_container = payment_repo.save(pr);

			// Checks if object is saved successfully
			if (payment_repo.findBypaymentRequestNo(pr_container.getPaymentRequestNo()) != null) {

				// Create Payable for encoded payment request
				Payables payable = new Payables();
				payable.setPaymentRequest(pr);

				Status status = new Status();
				status.setStatusId(1);
				payable.setStatus(status);

				payables_repo.save(payable);

				// Set PaymentRequest's assigned Payable
				pr.setPayables(payable);
				payment_repo.save(pr);
			} else {
				throw new MultipartException("Error saving payment request");
			}
		}
	}

	@PutMapping(path = "/updatePaymentRequest/{opt}")
	@ResponseBody
	public void updatePaymentRequest(@RequestBody PaymentRequest paymentRequest,
			@PathVariable("opt") String operation) {

		Payables payable = payables_repo.findByPaymentRequest(paymentRequest);

		// Switch Cased has been used if ever new action will be added in the future.
		switch (operation) {
		case "void":

			Status status = new Status();

			status.setStatusId(10);
			payable.setStatus(status);
			payables_repo.save(payable);

			break;
		default:
			System.out.println("Regular update with payment request id : " + paymentRequest.getPaymentRequestNo());
		}

		paymentRequest.setLastModified(Calendar.getInstance().getTime());
		paymentRequest.setPayables(payable);
		payment_repo.save(paymentRequest);
	}
	
	@PutMapping(path="/approvePaymentRequest")
	@ResponseBody
	public void approvePaymentRequest(@RequestBody PaymentRequest paymentRequest) {
		Payables payable = payables_repo.findByPaymentRequest(paymentRequest);
		
		Status status = new Status();
		status.setStatusId(12);
		
		payable.setStatus(status);
		payables_repo.save(payable);
		
		paymentRequest.setPayables(payable);
		paymentRequest.setDateApproved(Calendar.getInstance().getTime());
		payment_repo.save(paymentRequest);
	}
	
	@PutMapping(path="/disapprovePaymentRequest")
	@ResponseBody
	public void disapprovePaymentRequest(@RequestBody PaymentRequest paymentRequest) {
		Payables payable = payables_repo.findByPaymentRequest(paymentRequest);
		
		Status status = new Status();
		status.setStatusId(13);
		
		payable.setStatus(status);
		payables_repo.save(payable);
		
		paymentRequest.setPayables(payable);
		paymentRequest.setDateDisApproved(Calendar.getInstance().getTime());
		payment_repo.save(paymentRequest);
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
	
	@GetMapping(path = "/paymentRequests/entries")
	@ResponseBody
	public List<PaymentRequest> getPaymentRequestsByStatus() {
		List<PaymentRequest> paymentRequests = new ArrayList<>();
		List<Payables> payables = payables_repo.findByStatus_StatusId(1);
		
		for(Payables py: payables) {
			paymentRequests.add(py.getPaymentRequest());
		}
		
		return paymentRequests;
	}
	
	@GetMapping(path = "/paymentRequests/approval")
	@ResponseBody
	public List<PaymentRequest> getPaymentRequestForApproval() {
		List<PaymentRequest> paymentRequests = new ArrayList<>();
		List<Payables> payables = payables_repo.findByStatus_StatusId(12);
		
		for(Payables py: payables) {
			paymentRequests.add(py.getPaymentRequest());
		}
		
		return paymentRequests;
	}
	
	@GetMapping(path = "/paymentRequests/returned")
	@ResponseBody
	public List<PaymentRequest> getPaymentRequestForReturned() {
		List<PaymentRequest> paymentRequests = new ArrayList<>();
		List<Payables> payables = payables_repo.findByStatus_StatusId(13);
		
		for(Payables py: payables) {
			paymentRequests.add(py.getPaymentRequest());
		}
		
		return paymentRequests;
	}
}
