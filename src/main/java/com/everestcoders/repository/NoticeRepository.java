package com.everestcoders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everestcoders.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, String>{
	public List<Notice> findByUserId(String uid);
    public List<Notice> findByIsAdminMessage(boolean isadmin);
}
