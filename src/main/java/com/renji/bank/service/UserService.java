package com.renji.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renji.bank.entity.User;
import com.renji.bank.repository.UserRepository;

@Service
public class UserService {

	List<User> users = new ArrayList<User>();

	@Autowired
	UserRepository repository;

	public List<User> getAllUsers() {
		List<User> users = (List<User>) repository.findAll();
		return users;
	}

	public User getUser(int userId) {
		return repository.findById(userId);
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(int userId, User user) {
		User existingUser = repository.findById(userId);
		if (null != user.getName())
			existingUser.setName(user.getName());
		if (0!=user.getAge())
			existingUser.setAge(user.getAge());
		if (null != user.getAddress())
			existingUser.setAddress(user.getAddress());
		return repository.save(existingUser);
	}

	public void deleteUser(int userId) {
		repository.deleteById(userId);
		
	}

}
