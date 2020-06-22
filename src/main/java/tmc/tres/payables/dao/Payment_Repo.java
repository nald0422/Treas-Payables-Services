package tmc.tres.payables.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Status;

public interface Payment_Repo extends JpaRepository<PaymentRequest, Integer>{
	PaymentRequest findBypaymentRequestNo(long id);
	
//	@Modifying
//	@Transactional
//	@Query("update PaymentRequest par set par.status = :status where par.paymentRequestNo = :paymentRequestNo")
//	int setStatusForPaymentRequest(@Param("status") Status status, @Param("paymentRequestNo") Long paymentRequestNo);
}
