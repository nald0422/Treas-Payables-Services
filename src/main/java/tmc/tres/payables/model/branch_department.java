package tmc.tres.payables.model;

public class branch_department {
	
	private int sectionId;
	private String sectionCode;
	
	public int getSectionId() {
		return sectionId;
	}
	
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	
	public String getSectionCode() {
		return sectionCode;
	}
	
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	@Override
	public String toString() {
		return "branch_department [sectionId=" + sectionId + ", sectionCode=" + sectionCode + "]";
	}
}
