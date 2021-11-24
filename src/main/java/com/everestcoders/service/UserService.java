package com.everestcoders.service;

import java.util.List;

import com.everestcoders.model.User;

public interface UserService {
	public User saveUser(User user)throws Exception;
	public User saveHr(User user)throws Exception;
	public User updateUser(User user);
	public User getUser(String id);
	public User getUserByUserName(String name);
	public void deleteUser(Long id);
	public List<User> getAllUser();

}
