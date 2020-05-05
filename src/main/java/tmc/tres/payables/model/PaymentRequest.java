package tmc.tres.payables.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import tmc.tres.payables.model.primary_keys.PaymentRequestPK;

/**
 * @author Leshi
 */

@Entity
@Table(name = "Payables.Receivables.Tbl")
public class PaymentRequest {

	@Id
	@GeneratedValue
	@Column(name = "paymentRequestNo", nullable = false, updatable = false)
	private Long paymentRequestNo;

	@Basic
	private String payee;

	@Basic
	private Long amount;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateReceived;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateDue;

	@Basic
	private String particulars;

	@OneToOne
	private Status status;

	@OneToOne
	private Designation designation;

	@OneToOne
	private Section section;

	@OneToOne
	private Expense expense;

	public Long getPaymentRequestNo() {
		return paymentRequestNo;
	}

	public void setPaymentRequestNo(Long paymentRequestNo) {
		this.paymentRequestNo = paymentRequestNo;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
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

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	@Override
	public String toString() {
		return "PaymentRequest [paymentRequestNo=" + paymentRequestNo + ", payee=" + payee + ", amount=" + amount
				+ ", dateReceived=" + dateReceived + ", dateDue=" + dateDue + ", particulars=" + particulars
				+ ", status=" + status + ", designation=" + designation + ", section=" + section + ", expense="
				+ expense + "]";
	}

}