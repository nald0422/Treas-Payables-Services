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
@Table(name = "Payables.Release.Tbl")
public class Release {
	
	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private Long releaseId;
	
	@Basic
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
	private Long accountNumber;
	
	@OneToOne
	private PaymentRequest paymentRequest;
	
	@OneToOne
	private Disbursement disbursement;
	
	@OneToOne
	private Status status;
	
	
}
