package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.Expense;

public interface Expense_Repo extends JpaRepository<Expense, Integer>{

//	List<Expense> findByexpense_code(String expense);
	
//	@Modifying
//	@Transactional
//	@Query(value = "update Expense e set e.expenseCode = :expenseCode, e.expenseDesc = :expenseDesc where e.expenseId = :expenseId")
//	void setExpenseInfoById(String expenseCode, String expenseDesc, Long expenseId);
}
