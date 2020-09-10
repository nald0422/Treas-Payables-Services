package tmc.tres.payables.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Disbursement;
import tmc.tres.payables.model.Payables;
import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Release;

public interface Payables_Repo extends JpaRepository<Payables, Integer>{
	Payables findBypayablesId(long id);
	
	List<Payables> findByDisbursement(Disbursement db);
	
	Payables findByRelease(Release re);
	
	Payables findByPaymentRequest(PaymentRequest pr);
	
	List<Payables> findByStatus_StatusId(int id);
}
