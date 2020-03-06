package tmc.tres.payables.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;

import tmc.tres.payables.dao.ho_branch_repo;
import tmc.tres.payables.model.Designation;

@RestController
public class DesignationController {
	
	@Autowired
	ho_branch_repo repo;
	
	@RequestMapping("/addDesignation")
	@ResponseBody
	public void addDesignation(Designation designation) {
		repo.save(designation);
		System.out.println("Designated Saved");
	}
	
	@RequestMapping("/updateDesignation")
	@ResponseBody
	public void updateDesignation(Designation designation) {
		repo.save(designation);
		System.out.println("Designation Updated");

	}
	
	@RequestMapping(path="/designations", produces= {"application/json"})
	@ResponseBody
	public List<Designation> getDesignations() {
		return repo.findAll();
	}
	
	@RequestMapping("/getDesignation/{designationId}") 
	@ResponseBody
	public Optional<Designation> getDesignation(@PathVariable("designationId") int designationId) {
//		System.out.println("Id Passed: " + designationId);
//		System.out.println(repo.findBydesignationCode("BRANCH"));
		return repo.findById(designationId);
	}
}
