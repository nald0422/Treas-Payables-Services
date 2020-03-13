package tmc.tres.payables.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue
	@Column(name = "expenseId", updatable = false, nullable = false)
	private int expenseId;
	private String expenseCode;
	private String expenseDesc;
	
	@OneToMany(mappedBy="expenseCode")
	private List<PaymentRequest> paymentRequest;
	
	public String getExpenseCode() {
		return expenseCode;
	}
	
	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}
	
	public String getExpenseDesc() {
		return expenseDesc;
	}
	
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	
	@Override
	public String toString() {
		return "Expense [expenseCode=" + expenseCode + ", expenseDesc=" + expenseDesc + "]";
	}
	
	
	
}
