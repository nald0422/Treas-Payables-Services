package tmc.tres.payables.model;

import java.util.Date;

public class PaymentRequest {
	
	private Date dateReceived;
    private Date dateDue;
    private String Ho_Branch;
    private String Branch_Department;
    private String expenseCode;
    private String particulars;
    private int amount;
    private String payee;
    
	public Date getDateReceived() {
		return dateReceived;
	}
	
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	
	public Date getDateDue() {
		return dateDue;
	}
	
	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}
	
	public String getHo_Branch() {
		return Ho_Branch;
	}
	
	public void setHo_Branch(String ho_Branch) {
		Ho_Branch = ho_Branch;
	}
	
	public String getBranch_Department() {
		return Branch_Department;
	}
	
	public void setBranch_Department(String branch_Department) {
		Branch_Department = branch_Department;
	}
	
	public String getExpenseCode() {
		return expenseCode;
	}
	
	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}
	
	public String getParticulars() {
		return particulars;
	}
	
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getPayee() {
		return payee;
	}
	
	public void setPayee(String payee) {
		this.payee = payee;
	}

	@Override
	public String toString() {
		return "PaymentRequest [dateReceived=" + dateReceived + ", dateDue=" + dateDue + ", Ho_Branch=" + Ho_Branch
				+ ", Branch_Department=" + Branch_Department + ", expenseCode=" + expenseCode + ", particulars="
				+ particulars + ", amount=" + amount + ", payee=" + payee + "]";
	}
}
