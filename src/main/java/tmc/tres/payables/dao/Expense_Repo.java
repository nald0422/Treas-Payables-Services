package tmc.tres.payables.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tmc.tres.payables.model.Expense;

public interface Expense_Repo extends JpaRepository<Expense, Integer>{

	List<Expense> findByexpenseCode(String expense);
}
