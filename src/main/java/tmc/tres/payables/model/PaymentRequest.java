package tmc.tres.payables.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Leshi
 */

@Entity
@DynamicUpdate
@Table(name = "Payables.Receivables.Tbl")
public class PaymentRequest {

	@Id
	@GeneratedValue
	@Column(name = "paymentRequestNo", nullable = false, updatable = false)
	private long paymentRequestNo;

	@Basic
	private String payee;

	@Basic
	private long amount;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateReceived;

	@Basic
	@JsonIgnore
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateApproved;

	@Basic
	@JsonIgnore
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateDisApproved;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateDue;

	@Basic
	private String particulars;

	@OneToOne
	@JoinColumn(name = "designationId")
	private Designation designation;

	@OneToOne
	@JoinColumn(name = "sectionId")
	private Section section;

	@OneToOne
	@JoinColumn(name = "expenseId")
	private Expense expense;

	@OneToOne
	@JoinColumn(name = "payablesId", nullable = true)
	@JsonIgnore
	private Payables payables;

	@Basic
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date lastModified;

	public long getPaymentRequestNo() {
		return paymentRequestNo;
	}

	public void setPaymentRequestNo(long paymentRequestNo) {
		this.paymentRequestNo = paymentRequestNo;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
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

	public Payables getPayables() {
		return payables;
	}

	public void setPayables(Payables payables) {
		this.payables = payables;
	}

	public Date getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}

	public Date getDateDisApproved() {
		return dateDisApproved;
	}

	public void setDateDisApproved(Date dateDisApproved) {
		this.dateDisApproved = dateDisApproved;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "PaymentRequest [paymentRequestNo=" + paymentRequestNo + ", payee=" + payee + ", amount=" + amount
				+ ", dateReceived=" + dateReceived + ", dateDue=" + dateDue + ", particulars=" + particulars
				+ ", designation=" + designation + ", section=" + section + ", expense=" + expense + ", payables="
				+ payables + "]";
	}

}