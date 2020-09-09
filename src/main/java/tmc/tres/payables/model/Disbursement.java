package tmc.tres.payables.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Payables.Disbursement.Tbl")
public class Disbursement {

	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private long disbursementId;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date datePrepared;

	@Basic
	private String bankDescription;

	@Basic
	private String bankBranch;

	@Basic
	private String accountNumber;

	@Basic
	private long checkNumber;

	@Basic
	private long cvNumber;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date checkDate;

	@OneToOne
	@JoinColumn(name = "payablesId")
	@JsonIgnore
	private Payables payables;

	@OneToMany(fetch = FetchType.EAGER)
	private List<PaymentRequest> paymentRequests;

	@Basic
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastModified;

	public long getDisbursementId() {
		return disbursementId;
	}

	public void setDisbursementId(long disbursementId) {
		this.disbursementId = disbursementId;
	}

	public Date getDatePrepared() {
		return datePrepared;
	}

	public void setDatePrepared(Date datePrepared) {
		this.datePrepared = datePrepared;
	}

	public String getBankDescription() {
		return bankDescription;
	}

	public void setBankDescription(String bankDescription) {
		this.bankDescription = bankDescription;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(long checkNumber) {
		this.checkNumber = checkNumber;
	}

	public long getCvNumber() {
		return cvNumber;
	}

	public void setCvNumber(long cvNumber) {
		this.cvNumber = cvNumber;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Payables getPayables() {
		return payables;
	}

	public void setPayables(Payables payables) {
		this.payables = payables;
	}

	public List<PaymentRequest> getPaymentRequests() {
		return paymentRequests;
	}

	public void setPaymentRequests(List<PaymentRequest> paymentRequests) {
		this.paymentRequests = paymentRequests;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Disbursement [disbursementId=" + disbursementId + ", datePrepared=" + datePrepared
				+ ", bankDescription=" + bankDescription + ", bankBranch=" + bankBranch + ", accountNumber="
				+ accountNumber + ", checkNumber=" + checkNumber + ", cvNumber=" + cvNumber + ", checkDate=" + checkDate
				+ ", payables=" + payables + ", paymentRequests=" + paymentRequests + "]";
	}

}
