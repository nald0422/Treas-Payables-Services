package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.PaymentRequest;

public interface Payment_Repo extends JpaRepository<PaymentRequest, Integer>{
	PaymentRequest findBypaymentRequestNo(long id);
	
//	@Modifying
//	@Transactional
//	@Query("update PaymentRequest par set par.status = :status where par.paymentRequestNo = :paymentRequestNo")
//	int setStatusForPaymentRequest(@Param("status") Status status, @Param("paymentRequestNo") Long paymentRequestNo);
}
