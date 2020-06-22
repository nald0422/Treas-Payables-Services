package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Disbursement;
import tmc.tres.payables.model.PaymentRequest;

public interface Disbursement_Repo extends JpaRepository<Disbursement, Integer>{
	Disbursement findBydisbursementId(long id);
}