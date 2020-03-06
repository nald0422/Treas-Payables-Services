package tmc.tres.payables.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tmc.tres.payables.model.Designation;

public interface ho_branch_repo extends JpaRepository<Designation, Integer>{

	List<Designation> findBydesignationCode(String designation);
	
}
