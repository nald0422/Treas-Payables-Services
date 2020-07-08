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

import tmc.tres.payables.dao.Expense_Repo;
import tmc.tres.payables.model.Designation;
import tmc.tres.payables.model.Expense;

@RestController
public class ExpenseController {
	
	@Autowired
	Expense_Repo expense_repo;
	
	@PostMapping(path="/addExpense")
	@ResponseBody
	public void addExpense(@RequestBody Expense expense) {
		expense_repo.save(expense);
	}
	
	@PutMapping(path="/updateExpense")
	@ResponseBody
	public void updateDesignation(@RequestBody Expense expense) {
		expense_repo.save(expense);
	}
	
	@RequestMapping("/removeExpense/{expenseId}")
	public void deleteDesignation(@PathVariable("expenseId") int expenseId) {
		expense_repo.deleteById(expenseId);
	}
	
	@RequestMapping(path="/expenses", produces= {"application/json"})
	@ResponseBody
	public List<Expense> getExpenses() {
		return expense_repo.findAll();
	}
	
//	@RequestMapping("/getExpense/{expenseCode}") 
//	@ResponseBody
//	public List<Expense> getExpense(@PathVariable("expenseCode") String expenseCode) {
//		return expense_repo.findByexpense_code(expenseCode);
//	}
}
