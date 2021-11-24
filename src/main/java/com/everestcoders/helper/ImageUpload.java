package com.everestcoders.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUpload {

	public String uploadImage(MultipartFile file) {
		// getting new image

		try {
			if (!file.isEmpty()) {
				String newPic =UUID.randomUUID().toString()+"_"+ file.getOriginalFilename();
				File file2 = new ClassPathResource("static/img").getFile();
				Path savepath = Paths.get(file2.getAbsolutePath() + File.separator + newPic);
				Files.copy(file.getInputStream(), savepath, StandardCopyOption.REPLACE_EXISTING);
				
				return newPic;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;

	}

	public List<String> uploadImages(List<MultipartFile> files) {
		// getting new image
		List<String> myList = new ArrayList<String>();
		try {
			for (MultipartFile file : files) {

				String newPic =UUID.randomUUID().toString()+"_"+ file.getOriginalFilename();
				File file2 = new ClassPathResource("static/img").getFile();
				Path savepath = Paths.get(file2.getAbsolutePath() + File.separator + newPic);
				Files.copy(file.getInputStream(), savepath, StandardCopyOption.REPLACE_EXISTING);
				
				myList.add(newPic);
			}
			return myList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}

}
