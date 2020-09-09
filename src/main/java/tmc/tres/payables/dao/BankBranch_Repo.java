package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.BankBranch;

public interface BankBranch_Repo extends JpaRepository<BankBranch, Integer> {
	
	BankBranch findBybranchId(int id);
	
	BankBranch findByAccountNum(String accountNum);
}