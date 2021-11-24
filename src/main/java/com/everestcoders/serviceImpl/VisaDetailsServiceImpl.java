package com.everestcoders.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everestcoders.model.VisaDetails;
import com.everestcoders.repository.VisaDetailsRepository;
import com.everestcoders.service.VisaDetailsService;

@Service
public class VisaDetailsServiceImpl implements VisaDetailsService {

	@Autowired
	VisaDetailsRepository visaRepo;

	@Override
	public VisaDetails saveVisaDetail(VisaDetails vt) {
		vt.setId(UUID.randomUUID().toString());
		return visaRepo.save(vt);
	}

	@Override
	public VisaDetails UpdateVisaDetail(VisaDetails vt) {
		
		return visaRepo.save(vt);
	}

	@Override
	public List<VisaDetails> getAllVisaDetail() {
		
		return visaRepo.findAll();
	}

	@Override
	public VisaDetails getVisaDetailById(String typeId) {
		VisaDetails vDetails=null;
		List<VisaDetails> findAll = visaRepo.findAll();
		for (VisaDetails visaDetails : findAll) {
			if (visaDetails.getId().equals(typeId)) {
				vDetails=visaDetails;
			}
		}
		
		return vDetails;
	}

	@Override
	public void deleteVisaDetail(String typeId) {
		visaRepo.deleteById(typeId);

	}

}
