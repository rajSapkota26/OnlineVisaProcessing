package com.everestcoders.service;

import java.util.List;

import com.everestcoders.model.VisaDetails;

public interface VisaDetailsService {
	
	VisaDetails saveVisaDetail(VisaDetails vt);
	VisaDetails UpdateVisaDetail(VisaDetails vt);
    List<VisaDetails> getAllVisaDetail();
    VisaDetails getVisaDetailById(String typeId);
    void deleteVisaDetail(String typeId);
}
