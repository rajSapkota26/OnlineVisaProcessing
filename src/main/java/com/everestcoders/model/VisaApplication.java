package com.everestcoders.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisaApplication {
	
	@Id
	private String id;
    private String userId;
    private String visaType;
    private String fullName;
    private String birthPlace;
    private String permanentAddress;
    private String temporaryAddress;
    private String phone;
    private String email;
    private String occupation;
    private String passportNo;
    private String passportIssuedPlace;
    private String passportIssuedDate;
    private String passportExpiredDate;
    private String purposeOfVisit;
    private String durationOfVisit;
    private String lastVisit;
    private String noOfPreviousVisit;
    private String fees;
    private String nationality;
    private String sourceOfExpenditure ;
    private String otherCountryPasswordNo;
    private String status;    
    private String userPic;
    private String passportPic;
    private String vpPic;
    private String appliedPlace;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVisaType() {
		return visaType;
	}
	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getTemporaryAddress() {
		return temporaryAddress;
	}
	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getPassportIssuedPlace() {
		return passportIssuedPlace;
	}
	public void setPassportIssuedPlace(String passportIssuedPlace) {
		this.passportIssuedPlace = passportIssuedPlace;
	}
	public String getPassportIssuedDate() {
		return passportIssuedDate;
	}
	public void setPassportIssuedDate(String passportIssuedDate) {
		this.passportIssuedDate = passportIssuedDate;
	}
	public String getPassportExpiredDate() {
		return passportExpiredDate;
	}
	public void setPassportExpiredDate(String passportExpiredDate) {
		this.passportExpiredDate = passportExpiredDate;
	}
	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}
	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}
	
	public String getDurationOfVisit() {
		return durationOfVisit;
	}
	public void setDurationOfVisit(String durationOfVisit) {
		this.durationOfVisit = durationOfVisit;
	}
	public String getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}
	public String getNoOfPreviousVisit() {
		return noOfPreviousVisit;
	}
	public void setNoOfPreviousVisit(String noOfPreviousVisit) {
		this.noOfPreviousVisit = noOfPreviousVisit;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getSourceOfExpenditure() {
		return sourceOfExpenditure;
	}
	public void setSourceOfExpenditure(String sourceOfExpenditure) {
		this.sourceOfExpenditure = sourceOfExpenditure;
	}
	public String getOtherCountryPasswordNo() {
		return otherCountryPasswordNo;
	}
	public void setOtherCountryPasswordNo(String otherCountryPasswordNo) {
		this.otherCountryPasswordNo = otherCountryPasswordNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserPic() {
		return userPic;
	}
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	public String getPassportPic() {
		return passportPic;
	}
	public void setPassportPic(String passportPic) {
		this.passportPic = passportPic;
	}
	public String getVpPic() {
		return vpPic;
	}
	public void setVpPic(String vpPic) {
		this.vpPic = vpPic;
	}
	public String getAppliedPlace() {
		return appliedPlace;
	}
	public void setAppliedPlace(String appliedPlace) {
		this.appliedPlace = appliedPlace;
	}
	@Override
	public String toString() {
		return "VisaApplication [id=" + id + ", userId=" + userId + ", visaType=" + visaType + ", fullName=" + fullName
				+ ", birthPlace=" + birthPlace + ", permanentAddress=" + permanentAddress + ", temporaryAddress="
				+ temporaryAddress + ", phone=" + phone + ", email=" + email + ", occupation=" + occupation
				+ ", passportNo=" + passportNo + ", passportIssuedPlace=" + passportIssuedPlace
				+ ", passportIssuedDate=" + passportIssuedDate + ", passportExpiredDate=" + passportExpiredDate
				+ ", purposeOfVisit=" + purposeOfVisit + ", durationOfVisit="
				+ durationOfVisit + ", lastVisit=" + lastVisit + ", noOfPreviousVisit=" + noOfPreviousVisit + ", fees="
				+ fees + ", nationality=" + nationality + ", sourceOfExpenditure=" + sourceOfExpenditure
				+ ", otherCountryPasswordNo=" + otherCountryPasswordNo + ", status=" + status + ", userPic=" + userPic
				+ ", passportPic=" + passportPic + ", vpPic=" + vpPic + ", appliedPlace=" + appliedPlace + "]";
	}
    
    
}
