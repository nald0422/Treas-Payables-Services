package tmc.tres.payables.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Designation_Repo;
import tmc.tres.payables.model.Designation;

@RestController
public class DesignationController {
	
	@Autowired
	Designation_Repo designation_repo;
	
	@RequestMapping("/addDesignation")
	@ResponseBody
	public void addDesignation(Designation designation) {
		designation_repo.save(designation);
		System.out.println("Designated Saved");
	}
	
	@RequestMapping("/updateDesignation")
	@ResponseBody
	public void updateDesignation(Designation designation) {
		designation_repo.save(designation);
		System.out.println("Designation Updated");
	}
	
	@RequestMapping(path="/designations", produces= {"application/json"})
	@ResponseBody
	public List<Designation> getDesignations() {
		return designation_repo.findAll();
	}
	
	@RequestMapping("/getDesignation/{designationId}") 
	@ResponseBody
	public Optional<Designation> getDesignation(@PathVariable("designationId") int designationId) {
		return designation_repo.findById(designationId);
	}
}
