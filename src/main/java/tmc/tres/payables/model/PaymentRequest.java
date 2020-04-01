package tmc.tres.payables.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class PaymentRequest {
	
	@Id
	@GeneratedValue
	@Column(name = "paymentRequestNo", updatable = false, nullable = false)
	private int paymentRequestNo;      
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dateReceived;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dateDue;
	
	@ManyToOne
	@JoinColumn(name = "designationCode")
	@JsonProperty("designation")
	private	Designation designationCode;
	@ManyToOne
	@JsonProperty("section")
	@JoinColumn(name = "sectionCode")
	private Section sectionCode;
	@ManyToOne
	@JsonProperty("expense")
	@JoinColumn(name = "expenseCode")
	private Expense expenseCode;
	
	private String particulars;
	private long amount;
	private String Payee;
	public int getPaymentRequestNo() {
		return paymentRequestNo;
	}
	public void setPaymentRequestNo(int paymentRequestNo) {
		this.paymentRequestNo = paymentRequestNo;
	}
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
	public Designation getDesignationCode() {
		return designationCode;
	}
	public void setDesignationCode(Designation designationCode) {
		this.designationCode = designationCode;
	}
	public Section getSectionCode() {
		return sectionCode;
	}
	public void setSectionCode(Section sectionCode) {
		this.sectionCode = sectionCode;
	}
	public Expense getExpenseCode() {
		return expenseCode;
	}
	public void setExpenseCode(Expense expenseCode) {
		this.expenseCode = expenseCode;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getPayee() {
		return Payee;
	}
	public void setPayee(String payee) {
		Payee = payee;
	}
	@Override
	public String toString() {
		return "PaymentRequest [paymentRequestNo=" + paymentRequestNo + ", dateReceived=" + dateReceived + ", dateDue="
				+ dateDue + ", designationCode=" + designationCode + ", sectionCode=" + sectionCode + ", expenseCode="
				+ expenseCode + ", particulars=" + particulars + ", amount=" + amount + ", Payee=" + Payee + "]";
	}
	
	
}
