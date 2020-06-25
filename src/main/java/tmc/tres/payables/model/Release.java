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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Payables.Release.Tbl")
public class Release {

	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private long releaseId;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateFunded;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateCancelled;

	@Basic
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateReleased;

	@Basic
	private String receivedBy;

	@Basic
	private long accountNo;

	@OneToOne
	@JoinColumn(name = "payablesId")
	@JsonIgnore
	private Payables payables;

	public long getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(long releaseId) {
		this.releaseId = releaseId;
	}

	public Date getDateFunded() {
		return dateFunded;
	}

	public void setDateFunded(Date dateFunded) {
		this.dateFunded = dateFunded;
	}

	public Date getDateCancelled() {
		return dateCancelled;
	}

	public void setDateCancelled(Date dateCancelled) {
		this.dateCancelled = dateCancelled;
	}

	public Date getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(Date dateReleased) {
		this.dateReleased = dateReleased;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNumber) {
		this.accountNo = accountNumber;
	}

	public Payables getPayables() {
		return payables;
	}

	public void setPayables(Payables payables) {
		this.payables = payables;
	}

	@Override
	public String toString() {
		return "Release [releaseId=" + releaseId + ", dateFunded=" + dateFunded + ", dateCancelled=" + dateCancelled
				+ ", dateReleased=" + dateReleased + ", receivedBy=" + receivedBy + ", accountNo=" + accountNo
				+ ", payables=" + payables + "]";
	}

}
