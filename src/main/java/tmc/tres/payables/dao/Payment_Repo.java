package tmc.tres.payables.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.PaymentRequest;

public interface Payment_Repo extends JpaRepository<PaymentRequest, Integer>{
//	List<PaymentRequest> findBypayment_request_no(int id);
}
