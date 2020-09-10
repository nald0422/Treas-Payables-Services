package tmc.tres.payables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.BankBranch_Repo;
import tmc.tres.payables.dao.Bank_Repo;
import tmc.tres.payables.model.Bank;
import tmc.tres.payables.model.BankBranch;

@RestController
public class BankController {

	@Autowired
	Bank_Repo bank_repo;
	
	@Autowired
	BankBranch_Repo bankBranch_repo;

	@PostMapping(path = "/addBank")
	@ResponseBody
	public void addBank(@RequestBody Bank bank) {
		bank_repo.save(bank);
	}

	@PutMapping(path = "/updateBank")
	@ResponseBody
	public void updateBank(@RequestBody Bank bank) {
		bank_repo.save(bank);
	}

	@RequestMapping(path = "/banks", produces = { "application/json" })
	@ResponseBody
	public List<Bank> getBanks() {
		return bank_repo.findAll();
	}
	
	@RequestMapping(path = "/getBank/{bankDescription}")
	public Bank getBank(@PathVariable("bankDescription") String bankDescription) {
		return bank_repo.findBybankDescription(bankDescription);
	}


	@RequestMapping("/removeBank/{bankId}")
	public void deleteDesignation(@PathVariable("bankId") int bankId) {
		bank_repo.deleteById(bankId);
	}
	
	@RequestMapping("/bankBranches")
	public List<BankBranch> getBankBranches() {
		return bankBranch_repo.findAll();
	}
	
	@RequestMapping("/branch/{branchId}")
	public BankBranch getBranch(@PathVariable("branchId") String accountNum) {
		return bankBranch_repo.findByAccountNum(accountNum);
	}

}
