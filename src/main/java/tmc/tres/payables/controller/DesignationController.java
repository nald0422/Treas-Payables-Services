package tmc.tres.payables.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Designation_Repo;
import tmc.tres.payables.model.Designation;
import tmc.tres.payables.model.Expense;

@RestController
public class DesignationController {
	
	@Autowired
	Designation_Repo designation_repo;
	
	@PostMapping(path="/addDesignation")
	@ResponseBody
	public void addDesignation(@RequestBody Designation designation) {
		System.out.println(designation.toString());
		designation_repo.save(designation);
		System.out.println("Designated Saved");
	}
	
	@PutMapping(path="/updateDesignation")
	@ResponseBody
	public void updateDesignation(@RequestBody Designation designation) {
		designation_repo.setDesignationInfoById(designation.getDesignationCode(), designation.getDesignationDesc(), designation.getDesignationId());
		System.out.println("Designation Updated : " + designation.toString());
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
	
	@RequestMapping("/removeDesignation/{designationId}")
	public void deleteDesignation(@PathVariable("designationId") int designationId) {
		designation_repo.deleteById(designationId);
	}
}
