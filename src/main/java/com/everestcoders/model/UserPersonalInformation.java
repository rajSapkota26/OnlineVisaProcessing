package com.everestcoders.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPersonalInformation {
	 @Id  
	    private String id;
	    private String userId;
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    private String parentName;
	    private String passportNo;
	    private String passportIssueDate;
	    private String passportExpireDate;
	    private String passportIssueCountry;
	    private String country;
	    private String nationality;
	    private String street;
	    private String city;
	    private String road;
	    private String zipcode;
	    @Column(name = "pfPic", length = 1000)
	    private byte[] pfPicByte;
	    private String gender;
	    private String profile;
	    private String dateOfBirth;
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
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getParentName() {
			return parentName;
		}
		public void setParentName(String parentName) {
			this.parentName = parentName;
		}
		public String getPassportNo() {
			return passportNo;
		}
		public void setPassportNo(String passportNo) {
			this.passportNo = passportNo;
		}
		public String getPassportIssueDate() {
			return passportIssueDate;
		}
		public void setPassportIssueDate(String passportIssueDate) {
			this.passportIssueDate = passportIssueDate;
		}
		
		public String getPassportExpireDate() {
			return passportExpireDate;
		}
		public void setPassportExpireDate(String passportExpireDate) {
			this.passportExpireDate = passportExpireDate;
		}
		public String getPassportIssueCountry() {
			return passportIssueCountry;
		}
		public void setPassportIssueCountry(String passportIssueCountry) {
			this.passportIssueCountry = passportIssueCountry;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getRoad() {
			return road;
		}
		public void setRoad(String road) {
			this.road = road;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		public byte[] getPfPicByte() {
			return pfPicByte;
		}
		public void setPfPicByte(byte[] pfPicByte) {
			this.pfPicByte = pfPicByte;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		@Override
		public String toString() {
			return "UserPersonalInformation [id=" + id + ", userId=" + userId + ", firstName=" + firstName
					+ ", middleName=" + middleName + ", lastName=" + lastName + ", parentName=" + parentName
					+ ", passportNo=" + passportNo + ", passportIssueDate=" + passportIssueDate
					+ ", passportExpireDate=" + passportExpireDate + ", passportIssueCountry=" + passportIssueCountry
					+ ", country=" + country + ", nationality=" + nationality + ", street=" + street + ", city=" + city
					+ ", road=" + road + ", zipcode=" + zipcode + ", pfPicByte=" + Arrays.toString(pfPicByte)
					+ ", gender=" + gender + ", profile=" + profile + ", dateOfBirth=" + dateOfBirth + "]";
		}
		
		
	    
	    
}
