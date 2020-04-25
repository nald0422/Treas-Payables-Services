package tmc.tres.payables.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tmc.tres.payables.model.Section;

public interface Section_Repo extends JpaRepository<Section, Integer>{

//	List<Section> findBysection_code(String section);
	
//	@Modifying
//	@Transactional
//	@Query(value = "update Section s set s.sectionCode = :sectionCode, s.sectionDesc = :sectionDesc where s.sectionId = :sectionId")
//	void setSectionInfoById(String sectionCode, String sectionDesc, Long sectionId);
}
