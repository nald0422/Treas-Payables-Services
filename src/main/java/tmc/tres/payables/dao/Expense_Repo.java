package tmc.tres.payables.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tmc.tres.payables.model.Expense;

public interface Expense_Repo extends JpaRepository<Expense, Integer>{

	List<Expense> findByexpenseCode(String expense);
	
	@Modifying
	@Transactional
	@Query(value = "update Expense e set e.expenseCode = :expenseCode, e.expenseDesc = :expenseDesc where e.expenseId = :expenseId")
	void setExpenseInfoById(String expenseCode, String expenseDesc, Integer expenseId);
}
