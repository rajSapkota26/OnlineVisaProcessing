package com.everestcoders.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everestcoders.model.VisaInformation;
import com.everestcoders.repository.VisaInformationRepository;
import com.everestcoders.service.VisaInformationService;

@Service
public class VisaInformationServiceImpl implements VisaInformationService {
	@Autowired
	VisaInformationRepository viRepository;

	@Override
	public List<VisaInformation> getAll() {
		// TODO Auto-generated method stub
		return viRepository.findAll();
	}

	@Override
	public VisaInformation saveVisaInformation(VisaInformation vi) {
		vi.setId(UUID.randomUUID().toString());
		vi.setExpired(false);
		return viRepository.save(vi);
	}

	@Override
	public List<VisaInformation> getAllByPassportNo(String passno) {
		// TODO Auto-generated method stub
		return viRepository.findByPassportNo(passno);
	}

}
