package tmc.tres.payables.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Section {
	
	@Id
	@GeneratedValue
	@Column(name = "sectionId", updatable = false, nullable = false)
	private int sectionId;
	@Column(name="section_code")
	private String sectionCode;
	@Column(name="section_desc")
	private String sectionDesc;

	
	@OneToMany(mappedBy="sectionCode")
	private List<PaymentRequest> paymentRequest;
	
	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}
	
}
