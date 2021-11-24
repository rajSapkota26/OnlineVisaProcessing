package com.everestcoders.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.helper.ImageUpload;
import com.everestcoders.model.UserPersonalInformation;
import com.everestcoders.repository.UserPersonalInformationRepository;
import com.everestcoders.service.UserPersonalInformationService;

@Service
public class UserPersonalInformationServiceImpl implements UserPersonalInformationService {

	@Autowired
	UserPersonalInformationRepository informationRepository;
	@Autowired
	ImageUpload imageUpload;
	@Override
	public UserPersonalInformation saveUserPersonalInformation(UserPersonalInformation information,MultipartFile file) {
		// TODO Auto-generated method stub
		information.setId(UUID.randomUUID().toString());
		information.setProfile(imageUpload.uploadImage(file));
		return informationRepository.save(information);
	}

	@Override
	public UserPersonalInformation updateUserPersonalInformation(UserPersonalInformation information) {
		
		return informationRepository.save(information);
	}

	@Override
	public UserPersonalInformation getUserPersonalInformationById(String id) {
		// TODO Auto-generated method stub
		return informationRepository.findById(id).get();
	}

	@Override
	public void deleteById(String id) {
		informationRepository.deleteById(id);

	}

	@Override
	public UserPersonalInformation getUserPersonalInformationByUserId(String userId) {
		// TODO Auto-generated method stub
		return informationRepository.getUserPersonalInformationByUserId(userId);
	}

}
