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
@Table(name = "Payables.Section.Tbl")
public class Section {

	@Id
	@GeneratedValue
	private Long section_id;

	@Basic
	private String section_code;

	@Basic
	private String section_description;

	public Long getSection_id() {
		return section_id;
	}

	public void setSection_id(Long section_id) {
		this.section_id = section_id;
	}

	public String getSection_code() {
		return section_code;
	}

	public void setSection_code(String section_code) {
		this.section_code = section_code;
	}

	public String getSection_description() {
		return section_description;
	}

	public void setSection_description(String section_description) {
		this.section_description = section_description;
	}

}