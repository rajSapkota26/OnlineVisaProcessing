package com.everestcoders.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.helper.ImageUpload;
import com.everestcoders.model.Notice;
import com.everestcoders.repository.NoticeRepository;
import com.everestcoders.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	@Autowired
	ImageUpload imageUpload;
	@Override
	public Notice saveNotice(Notice notice,MultipartFile file) {
		notice.setId(UUID.randomUUID().toString());
		notice.setAdminMessage(false);
		notice.setImage(imageUpload.uploadImage(file));
		return noticeRepository.save(notice);
	}

	@Override
	public Notice UpdateNotice(Notice notice,MultipartFile file) {
		// TODO Auto-generated method stub
		return noticeRepository.save(notice);
	}

	@Override
	public List<Notice> getAllNoticeByUserId(String userId) {
		// TODO Auto-generated method stub
		return noticeRepository.findByUserId(userId);
	}

	@Override
	public List<Notice> getAllAdminNotice() {
		// TODO Auto-generated method stub
		return noticeRepository.findByIsAdminMessage(true);
	}

	@Override
	public List<Notice> getAllNotice() {
		// TODO Auto-generated method stub
		return noticeRepository.findAll();
	}

	@Override
	public Notice getNoticeById(String noticeId) {
		
		return noticeRepository.findById(noticeId).get();
	}

	@Override
	public void deleteNotice(String noticeId) {
		noticeRepository.deleteById(noticeId);

	}

	@Override
	public Notice saveAdminNotice(Notice notice,MultipartFile file) {
		notice.setId(UUID.randomUUID().toString());
		notice.setAdminMessage(true);
		notice.setImage(imageUpload.uploadImage(file));
		return noticeRepository.save(notice);
	}

}
