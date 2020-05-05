package tmc.tres.payables.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payables.Status.Tbl")
public class Status {
	
	@Id
	@GeneratedValue
	@Column(nullable = false, updatable = false)
	private int statusId;
	
	@Basic
	private String statusDescription;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusDescription=" + statusDescription + "]";
	}
	
}
