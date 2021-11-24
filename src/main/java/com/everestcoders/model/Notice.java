package com.everestcoders.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notice {
	@Id
	private String id;
    private String userId;
    private String title;
    private String content;
    private String image;
    private boolean isAdminMessage;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isAdminMessage() {
		return isAdminMessage;
	}
	public void setAdminMessage(boolean isAdminMessage) {
		this.isAdminMessage = isAdminMessage;
	}
    
    
}
