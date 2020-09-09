package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Bank;

public interface Bank_Repo extends JpaRepository<Bank, Integer>{
	Bank findBybankDescription(String bankDescription);
}