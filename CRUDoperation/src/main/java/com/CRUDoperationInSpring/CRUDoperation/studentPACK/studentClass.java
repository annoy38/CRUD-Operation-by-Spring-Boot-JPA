package com.CRUDoperationInSpring.CRUDoperation.studentPACK;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentInfo")
public class studentClass {

	@Id
	private String sId;
	private String sName;
	private String sSection;
	private String sBatch;
	
	public studentClass() {
		super();
	}
	
	public studentClass(String sId, String sName, String sSection, String sBatch) {
		this.sId = sId;
		this.sName = sName;
		this.sSection = sSection;
		this.sBatch = sBatch;
	}

	public String getsId() {
		return sId;
	}

	public String getsName() {
		return sName;
	}

	public String getsSection() {
		return sSection;
	}

	public String getsBatch() {
		return sBatch;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public void setsSection(String sSection) {
		this.sSection = sSection;
	}

	public void setsBatch(String sBatch) {
		this.sBatch = sBatch;
	}
	
	
}
