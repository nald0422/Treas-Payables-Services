package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Status;

public interface Status_Repo extends JpaRepository<Status, Integer>{	
	
}
