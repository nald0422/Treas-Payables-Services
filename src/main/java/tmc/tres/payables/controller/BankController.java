package tmc.tres.payables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Bank_Repo;
import tmc.tres.payables.model.Bank;
import tmc.tres.payables.model.Designation;

@RestController
public class BankController {

	@Autowired
	Bank_Repo bank_repo;

	@PostMapping(path = "/addBank")
	@ResponseBody
	public void addBank(@RequestBody Bank bank) {
		System.out.println(bank.toString());
		bank_repo.save(bank);
	}

	@PutMapping(path = "/updateBank")
	@ResponseBody
	public void updateBank(@RequestBody Bank bank) {
	}

	@RequestMapping(path = "/banks", produces = { "application/json" })
	@ResponseBody
	public List<Bank> getBanks() {
		return bank_repo.findAll();
	}

}
