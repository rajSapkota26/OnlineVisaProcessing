package com.everestcoders.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.everestcoders.model.User;
import com.everestcoders.repository.UserRepository;
import com.everestcoders.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private BCryptPasswordEncoder PasswordEncoder;
	@Override
	public User saveUser(User user) throws Exception{
		User local = repository.getUserByUserName(user.getEmail());
		if (local !=null) {
			throw new Exception("user already exist");
		}
		 String id = UUID.randomUUID().toString();
		 user.setId(id);
		user.setRole("ROLE_USER");
		user.setActivity(true);
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User saveHr(User user) throws Exception{
//		 String id = UUID.randomUUID().toString();
//		 user.setId(id);
//		user.setRole("ROLE_HR");
//		user.setActivity(true);
//		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}


	@Override
	public User getUserByUserName(String name) {
		// TODO Auto-generated method stub
		return repository.getUserByUserName(name);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

}
