package tmc.tres.payables.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payables.Bank.Tbl")
public class Bank {

	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private int bank_id;
	
	@Basic
	private String bank_code;
	
	@Basic
	private String bank_description;

	public int getBankId() {
		return bank_id;
	}

	public void setBankId(int bankId) {
		this.bank_id = bankId;
	}

	public String getBankCode() {
		return bank_code;
	}

	public void setBankCode(String bankCode) {
		this.bank_code = bankCode;
	}

	public String getBankDescription() {
		return bank_description;
	}

	public void setBankDescription(String bankDescription) {
		this.bank_description = bankDescription;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bank_id + ", bankCode=" + bank_code + ", bankDescription=" + bank_description + "]";
	}
	
	
	
}
