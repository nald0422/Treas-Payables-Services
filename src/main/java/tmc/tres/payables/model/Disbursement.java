package tmc.tres.payables.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToOne	
	@JoinColumn(name = "bankId")
	private Bank bank;

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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
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

	@Override
	public String toString() {
		return "Disbursement [disbursementId=" + disbursementId + ", datePrepared=" + datePrepared + ", bank=" + bank
				+ ", checkNumber=" + checkNumber + ", cvNumber=" + cvNumber + ", checkDate=" + checkDate + ", payables="
				+ payables + "]";
	}

}
