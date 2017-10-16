package com.stfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stfo.models.User;
import com.stfo.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User addUser(User user) {
		return this.userRepository.save(user);
	}

	public User getUserWithId(String userId) {
		return this.userRepository.findOne(userId);
	}

	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	public User updateUserWithId(String userId, User user) {
		User exists = getUserWithId(userId);
		user.setId(userId);
		if (exists == null) {
			return null;
		} else {
			return this.userRepository.save(user);
		}
	}
}
