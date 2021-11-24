package com.everestcoders.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VisaDetails {
	@Id   
    private String id;
    private String name;
    private String timePeriod;
    private String visaAmount;
    private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	public String getVisaAmount() {
		return visaAmount;
	}
	public void setVisaAmount(String visaAmount) {
		this.visaAmount = visaAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "VisaDetails [id=" + id + ", name=" + name + ", timePeriod=" + timePeriod + ", visaAmount=" + visaAmount
				+ ", description=" + description + "]";
	}
    
    
    
}
