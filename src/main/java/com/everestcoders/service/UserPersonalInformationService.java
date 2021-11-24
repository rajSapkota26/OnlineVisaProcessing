package com.everestcoders.service;

import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.model.UserPersonalInformation;

public interface UserPersonalInformationService {
	
	public UserPersonalInformation saveUserPersonalInformation(UserPersonalInformation information,MultipartFile file);
	public UserPersonalInformation updateUserPersonalInformation(UserPersonalInformation information);
	public UserPersonalInformation getUserPersonalInformationById(String id);
	public void deleteById(String id);
	public UserPersonalInformation getUserPersonalInformationByUserId(String userId);

}
