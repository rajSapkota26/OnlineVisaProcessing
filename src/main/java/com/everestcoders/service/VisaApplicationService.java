package com.everestcoders.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.model.VisaApplication;

public interface VisaApplicationService {

	public VisaApplication saveData(VisaApplication va,List<MultipartFile> files);
	public VisaApplication updateData(VisaApplication va);
	public VisaApplication getDataById(String id);
	public List<VisaApplication> getAll();
	public void deleteDataById(String id);
	public VisaApplication getDataByUserIdAndVisaType(String userId,String visaType);
	public VisaApplication getDataByUserId(String userId);
}
