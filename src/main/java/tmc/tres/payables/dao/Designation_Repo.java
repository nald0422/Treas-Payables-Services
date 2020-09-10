package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Designation;

public interface Designation_Repo extends JpaRepository<Designation, Integer>{

//	List<Designation> findBydesignation_code(String designation);
	
//	@Modifying
//	@Transactional
//	@Query(value = "update Designation d set d.designationCode = :designationCode, d.designationDesc = :designationDesc where d.designationId = :designationId")
//	void setDesignationInfoById(String designationCode, String designationDesc, Long designationId);
	
}
