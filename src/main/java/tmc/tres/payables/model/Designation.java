package tmc.tres.payables.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Leshi
 */

@Entity
@Table(name = "Payables.Designation.Tbl")
public class Designation {

	@Id
	@GeneratedValue
	private Long designation_id;

	@Basic
	private String designation_code;

	@Basic
	private String designation_description;

	public Long getDesignation_id() {
		return designation_id;
	}

	public void setDesignation_id(Long designation_id) {
		this.designation_id = designation_id;
	}

	public String getDesignation_code() {
		return designation_code;
	}

	public void setDesignation_code(String designation_code) {
		this.designation_code = designation_code;
	}

	public String getDesignation_description() {
		return designation_description;
	}

	public void setDesignation_description(String designation_description) {
		this.designation_description = designation_description;
	}

}