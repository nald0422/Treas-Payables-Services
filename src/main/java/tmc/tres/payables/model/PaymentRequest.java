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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import tmc.tres.payables.model.primary_keys.PaymentRequestPK;

/**
 * @author Leshi
 */

@Entity
public class PaymentRequest {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long payment_request_no;

    @Basic
    private String payee;

    @Basic
    private Long amount;

    @Basic
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date date_received;

    @Basic
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date date_due;

    @Basic
    private String particulars;

    @Basic
    private String status;

    @OneToOne
    private Designation designation;

    @OneToOne
    private Section section;

    @OneToOne
    private Expense expense;

    public Long getPayment_request_no() {
        return payment_request_no;
    }

    public void setPayment_request_no(Long payment_request_no) {
        this.payment_request_no = payment_request_no;
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

    public Date getDate_received() {
        return date_received;
    }

    public void setDate_received(Date date_received) {
        this.date_received = date_received;
    }

    public Date getDate_due() {
        return date_due;
    }

    public void setDate_due(Date date_due) {
        this.date_due = date_due;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
		return "PaymentRequest [payment_request_no=" + payment_request_no + ", payee=" + payee + ", amount=" + amount
				+ ", date_received=" + date_received + ", date_due=" + date_due + ", particulars=" + particulars
				+ ", status=" + status + ", designation=" + designation + ", section=" + section + ", expense="
				+ expense + "]";
	}
    
    

}