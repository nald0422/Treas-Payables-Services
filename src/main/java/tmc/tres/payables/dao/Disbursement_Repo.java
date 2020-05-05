package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Disbursement;

public interface Disbursement_Repo extends JpaRepository<Disbursement, Integer>{

}