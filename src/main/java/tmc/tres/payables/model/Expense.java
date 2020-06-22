package tmc.tres.payables.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Leshi
 */

@Entity
@Table(name = "Payables.Expense.Tbl")
public class Expense {

	@Id
	@GeneratedValue
	private long expense_id;

	@Basic
	private String expense_code;

	@Basic
	private String expense_description;

	public long getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(long expense_id) {
		this.expense_id = expense_id;
	}

	public String getExpense_code() {
		return expense_code;
	}

	public void setExpense_code(String expense_code) {
		this.expense_code = expense_code;
	}

	public String getExpense_description() {
		return expense_description;
	}

	public void setExpense_description(String expense_description) {
		this.expense_description = expense_description;
	}

}
