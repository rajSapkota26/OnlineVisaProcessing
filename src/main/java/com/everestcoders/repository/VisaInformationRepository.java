package com.everestcoders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everestcoders.model.VisaInformation;

public interface VisaInformationRepository extends JpaRepository<VisaInformation, String>{

	public List<VisaInformation> findByPassportNo(String passportno);
}
