package tmc.tres.payables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Status_Repo;
import tmc.tres.payables.model.Status;

@RestController
public class StatusController {

	@Autowired
	Status_Repo status_repo;
	
	@PostMapping(path = "/addStatus")
	@ResponseBody
	public void addStatus(@RequestBody Status status) {
		status_repo.save(status);
	}
	
	@PutMapping(path = "/updateStatus")
	@ResponseBody
	
	public void updateStatus(@RequestBody Status status) {
		status_repo.save(status);
	}
	
	@GetMapping(path = "/status")
	@ResponseBody
	public List<Status> getStatus() {
		return status_repo.findAll();
	}
	
	@GetMapping(path = "/getStatus/{id}")
	@ResponseBody
	public Status getStatus(@PathVariable("id") int statusId) {
		return status_repo.findBystatusId(statusId);
	}
	
}
