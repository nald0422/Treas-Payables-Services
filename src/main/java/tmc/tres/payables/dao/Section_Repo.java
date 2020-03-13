package tmc.tres.payables.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tmc.tres.payables.model.Section;

public interface Section_Repo extends JpaRepository<Section, Integer>{

	List<Section> findBysectionCode(String section);
	
}
