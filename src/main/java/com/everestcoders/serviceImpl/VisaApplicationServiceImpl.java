package com.everestcoders.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.helper.ImageUpload;
import com.everestcoders.model.VisaApplication;
import com.everestcoders.repository.VisaApplicationRepository;
import com.everestcoders.service.VisaApplicationService;

@Service
public class VisaApplicationServiceImpl implements VisaApplicationService{

	@Autowired
	VisaApplicationRepository visaApplicationRepository;
	@Autowired
	ImageUpload imageUpload;
	@Override
	public VisaApplication saveData(VisaApplication va,List<MultipartFile> files) {
		va.setId(UUID.randomUUID().toString());
		List<String> list = imageUpload.uploadImages(files);
		va.setUserPic(list.get(0));
		va.setPassportPic(list.get(1));
		va.setVpPic(list.get(2));
		va.setStatus("Submitted");
		
		return visaApplicationRepository.save(va);
	}

	@Override
	public VisaApplication getDataById(String id) {
		
		return visaApplicationRepository.findById(id).get();
	}

	@Override
	public void deleteDataById(String id) {
		visaApplicationRepository.deleteById(id);
		
	}

	@Override
	public VisaApplication getDataByUserIdAndVisaType(String userId, String visaType) {
		
		return visaApplicationRepository.findByUserIdAndVisaType(userId, visaType);
	}

	@Override
	public List<VisaApplication> getAll() {
		// TODO Auto-generated method stub
		return visaApplicationRepository.findAll();
	}

	@Override
	public VisaApplication updateData(VisaApplication va) {
		VisaApplication va1=	visaApplicationRepository.findById(va.getId()).get();
		va1.setStatus("Pending");
		return visaApplicationRepository.save(va1);
	}

	@Override
	public VisaApplication getDataByUserId(String userId) {
		// TODO Auto-generated method stub
		return visaApplicationRepository.findByUserId(userId);
	}

}
