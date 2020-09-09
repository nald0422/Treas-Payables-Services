package tmc.tres.payables.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Payables.BankBranch.Tbl")
public class BankBranch {

	@Id
	@GeneratedValue
	@Column(name = "branchId", nullable = false, updatable = false)
	private int branchId;

	@Basic
	private String branch;

	@Basic
	private String accountNum;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
