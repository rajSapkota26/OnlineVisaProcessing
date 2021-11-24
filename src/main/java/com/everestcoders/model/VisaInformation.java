package com.everestcoders.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisaInformation {
	
	@Id
	private String id;
    private String clientName;
    private String passportNo;
    private String visaType;
    private String startingDate;
    private String endingDate;
    private boolean isExpired=false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getVisaType() {
		return visaType;
	}
	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}
	public String getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}
	public String getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	@Override
	public String toString() {
		return "VisaInformation [id=" + id + ", clientName=" + clientName + ", passportNo=" + passportNo + ", visaType="
				+ visaType + ", startingDate=" + startingDate + ", endingDate=" + endingDate + ", isExpired="
				+ isExpired + "]";
	}
    
    

}
