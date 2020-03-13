package tmc.tres.payables.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.dao.Expense_Repo;
import tmc.tres.payables.model.Expense;

@RestController
public class ExpenseController {
	
	@Autowired
	Expense_Repo expense_repo;
	
	@RequestMapping("/addExpense")
	@ResponseBody
	public void addExpense(Expense expense) {
		expense_repo.save(expense);
		System.out.println("Expense Saved");
	}
	
	@RequestMapping("/updateExpense")
	@ResponseBody
	public void updateExpense(Expense expense) {
		expense_repo.save(expense);
		System.out.println("Expense Updated");
	}
	
	@RequestMapping(path="/expenses", produces= {"application/json"})
	@ResponseBody
	public List<Expense> getExpenses() {
		return expense_repo.findAll();
	}
	
	@RequestMapping("/getExpense/{expenseCode}") 
	@ResponseBody
	public List<Expense> getExpense(@PathVariable("expenseCode") String expenseCode) {
		return expense_repo.findByexpenseCode(expenseCode);
	}
}
