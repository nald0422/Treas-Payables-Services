package tmc.tres.payables.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Designation {
	
	@Id
	@GeneratedValue
	@Column(name = "designationId", updatable = false, nullable = false)
	private int designationId;
	private String designationCode;
	private String designationDesc;
	
	@OneToMany(mappedBy="designationCode")
	private List<PaymentRequest> paymentRequest;

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

	public String getDesignationDesc() {
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
	}

	@Override
	public String toString() {
		return "Designation [designationId=" + designationId + ", designationCode=" + designationCode
				+ ", designationDesc=" + designationDesc + ", paymentRequest=" + paymentRequest + "]";
	}
	
}
