package tmc.tres.payables.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payables.Tbl")
public class Payables {

	@Id
	@GeneratedValue
	@Column(name = "payablesId", nullable = false, updatable = false)
	private long payablesId;

	@OneToOne
	@JoinColumn(name = "paymentRequestNo")
	private PaymentRequest paymentRequest;

	@OneToOne
	@JoinColumn(name = "disbursementId")
	private Disbursement disbursement;

	@OneToOne
	@JoinColumn(name = "releaseId")
	private Release release;

	@OneToOne
	@JoinColumn(name = "statusId")
	private Status status;

	public long getPayablesId() {
		return payablesId;
	}

	public void setPayablesId(long payablesId) {
		this.payablesId = payablesId;
	}

	public PaymentRequest getPaymentRequest() {
		return paymentRequest;
	}

	public void setPaymentRequest(PaymentRequest paymentRequest) {
		this.paymentRequest = paymentRequest;
	}

	public Disbursement getDisbursement() {
		return disbursement;
	}

	public void setDisbursement(Disbursement disbursement) {
		this.disbursement = disbursement;
	}

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payables [payablesId=" + payablesId + ", paymentRequest=" + paymentRequest + ", disbursement="
				+ disbursement + ", release=" + release + ", status=" + status + "]";
	}

}
