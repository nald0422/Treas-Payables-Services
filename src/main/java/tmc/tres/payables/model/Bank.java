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
	private int bankId;
	
	@Basic
	private String bankCode;
	
	@Basic
	private String bankDescription;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankDescription() {
		return bankDescription;
	}

	public void setBankDescription(String bankDescription) {
		this.bankDescription = bankDescription;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankCode=" + bankCode + ", bankDescription=" + bankDescription + "]";
	}
	
	
	
}
