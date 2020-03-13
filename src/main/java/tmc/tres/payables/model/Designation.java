package tmc.tres.payables.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Designation {
	
	@Id
	@GeneratedValue
	@Column(name = "designationId", updatable = false, nullable = false)
	private int designationId;
	@Column(name="designation_code")
	private String designationCode;
	@Column(name="designation_desc")
	private String designationCategory;
	
	@OneToMany(mappedBy="designationCode")
	private List<PaymentRequest> paymentRequest;

	public String getDesignationCode() {
		return designationCode;
	}

	public void setDesignationCode(String designationCode) {
		this.designationCode = designationCode;
	}

	public String getDesignationCategory() {
		return designationCategory;
	}

	public void setDesignationCategory(String designationCategory) {
		this.designationCategory = designationCategory;
	}
}
