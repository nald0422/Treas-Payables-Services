package tmc.tres.payables.model.primary_keys;

import java.io.Serializable;
import java.util.Objects;

public class PaymentRequestPK implements Serializable {

	private Long payment_request_no;
	private Long designation;
	private Long section;
	private Long expense;

	public PaymentRequestPK() {
	}

	public PaymentRequestPK(Long payment_request_no, Long designation, Long section, Long expense) {
		this.payment_request_no = payment_request_no;
		this.designation = designation;
		this.section = section;
		this.expense = expense;
	}

	public Long getPayment_request_no() {
		return payment_request_no;
	}

	public void setPayment_request_no(Long payment_request_no) {
		this.payment_request_no = payment_request_no;
	}

	public Long getDesignation() {
		return designation;
	}

	public void setDesignation(Long designation) {
		this.designation = designation;
	}

	public Long getSection() {
		return section;
	}

	public void setSection(Long section) {
		this.section = section;
	}

	public Long getExpense() {
		return expense;
	}

	public void setExpense(Long expense) {
		this.expense = expense;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!Objects.equals(getClass(), obj.getClass())) {
			return false;
		}
		final PaymentRequestPK other = (PaymentRequestPK) obj;
		if (!java.util.Objects.equals(this.getPayment_request_no(), other.getPayment_request_no())) {
			return false;
		}
		if (!java.util.Objects.equals(this.getDesignation(), other.getDesignation())) {
			return false;
		}
		if (!java.util.Objects.equals(this.getSection(), other.getSection())) {
			return false;
		}
		if (!java.util.Objects.equals(this.getExpense(), other.getExpense())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + Objects.hashCode(this.getPayment_request_no());
		hash = 31 * hash + Objects.hashCode(this.getDesignation());
		hash = 31 * hash + Objects.hashCode(this.getSection());
		hash = 31 * hash + Objects.hashCode(this.getExpense());
		return hash;
	}

	@Override
	public String toString() {
		return "PaymentRequestPK{" + " payment_request_no=" + payment_request_no + ", designation=" + designation
				+ ", section=" + section + ", expense=" + expense + '}';
	}

}
