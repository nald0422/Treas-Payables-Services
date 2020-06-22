package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Disbursement;
import tmc.tres.payables.model.Payables;
import tmc.tres.payables.model.PaymentRequest;
import tmc.tres.payables.model.Release;

public interface Payables_Repo extends JpaRepository<Payables, Integer>{
	Payables findBypayablesId(long id);
	
	Payables findByDisbursement(Disbursement id);
	
	Payables findByRelease(Release id);
	
	Payables findByPaymentRequest(PaymentRequest id);
}
