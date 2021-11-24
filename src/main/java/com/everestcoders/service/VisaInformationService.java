package com.everestcoders.service;

import java.util.List;

import com.everestcoders.model.VisaInformation;

public interface VisaInformationService {
	public List<VisaInformation> getAll();
	public VisaInformation saveVisaInformation(VisaInformation vi);
	public List<VisaInformation> getAllByPassportNo(String passno);
}
