package tmc.tres.payables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Disbursement_Repo;
import tmc.tres.payables.model.Disbursement;
import tmc.tres.payables.model.Status;

@RestController
public class DisbursementController {

	@Autowired
	Disbursement_Repo disbursement_repo;

	@PostMapping(path = "/addDisbursement")
	@ResponseBody
	public void addDisbursement(@RequestBody Disbursement disbursement) {

		Status status = new Status();
		status.setStatusId(2);

		disbursement.setStatus(status);

		disbursement_repo.save(disbursement);
	}

	@PutMapping(path = "/updateDisbursement")
	@ResponseBody
	public void updateDisbursement(@RequestBody Disbursement disbursement) {
		disbursement_repo.save(disbursement);
	}

	@GetMapping(path = "/disbursements")
	@ResponseBody
	public List<Disbursement> getDisbursements() {
		return disbursement_repo.findAll();
	}

}
