package com.everestcoders.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.everestcoders.model.Notice;

public interface NoticeService {

	Notice saveNotice(Notice notice,MultipartFile file);
	Notice saveAdminNotice(Notice notice,MultipartFile file);
	Notice UpdateNotice(Notice notice,MultipartFile file);
    List<Notice> getAllNoticeByUserId(String userId);
    List<Notice> getAllAdminNotice();
    List<Notice> getAllNotice();
    Notice getNoticeById(String noticeId);
    void deleteNotice(String noticeId);
}
