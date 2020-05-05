package tmc.tres.payables.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Payables.Disbursement.Tbl")
public class Disbursement {

	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private Long disbursementId;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date datePrepared;

	@OneToOne
	private Bank bank;

	@Basic
	private long checkNumber;

	@Basic
	private long cvNumber;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date checkDate;

	@OneToOne
	private PaymentRequest payment_request;

	@OneToOne
	private Status status;

	public Long getDisbursementId() {
		return disbursementId;
	}

	public void setDisbursementId(Long disbursementId) {
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

	public PaymentRequest getPayment_request() {
		return payment_request;
	}

	public void setPayment_request(PaymentRequest payment_request) {
		this.payment_request = payment_request;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Disbursement [disbursementId=" + disbursementId + ", datePrepared=" + datePrepared + ", bank=" + bank
				+ ", checkNumber=" + checkNumber + ", cvNumber=" + cvNumber + ", checkDate=" + checkDate
				+ ", payment_request=" + payment_request + ", status=" + status + "]";
	}

}
