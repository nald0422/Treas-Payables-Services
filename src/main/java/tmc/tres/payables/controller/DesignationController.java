package tmc.tres.payables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import tmc.tres.payables.dao.ho_branch_repo;
import tmc.tres.payables.model.ho_branch;

@Controller
public class DesignationController {
	
	@Autowired
	ho_branch_repo repo;
	
	@RequestMapping("/addDesignation")
	public String addDesignation(ho_branch designation) {
		repo.save(designation);
		return "test";
	}
	
	@RequestMapping("/updateDesignation")
	public void updateDesignation(ho_branch designation) {
		repo.save(designation);
	}
}
