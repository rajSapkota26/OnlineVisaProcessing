package com.everestcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everestcoders.model.VisaApplication;

public interface VisaApplicationRepository extends JpaRepository<VisaApplication, String>{
	
	public VisaApplication findByUserIdAndVisaType(String userid,String visatype);
	public VisaApplication findByUserId(String userid);

}
