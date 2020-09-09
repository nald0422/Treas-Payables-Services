package tmc.tres.payables.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@JsonManagedReference
	@OneToMany(mappedBy = "bank")
	private List<BankBranch> bankBranches;

	public int getBank_id() {
		return bankId;
	}

	public void setBank_id(int bank_id) {
		this.bankId = bank_id;
	}

	public String getBank_code() {
		return bankCode;
	}

	public void setBank_code(String bank_code) {
		this.bankCode = bank_code;
	}

	public String getBank_description() {
		return bankDescription;
	}

	public void setBank_description(String bank_description) {
		this.bankDescription = bank_description;
	}

	public List<BankBranch> getBankBranches() {
		return bankBranches;
	}

	public void setBankBranches(List<BankBranch> bankBranches) {
		this.bankBranches = bankBranches;
	}
}
