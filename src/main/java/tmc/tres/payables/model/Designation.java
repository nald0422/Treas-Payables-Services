package tmc.tres.payables.model;

import javax.persistence.*;

@Entity
public class Designation {
	
	@Id
	private int designationId;
	private String designationCode;
	
	public int getDesignationId() {
		return designationId;
	}
	
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	
	public String getDesignationCode() {
		return designationCode;
	}
	
	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}
	
	@Override
	public String toString() {
		return "ho_branch [designationId=" + designationId + ", designationCode=" + designationCode + "]";
	}
}
