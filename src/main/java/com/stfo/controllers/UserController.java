package com.stfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.models.User;
import com.stfo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user); 
	}
	
	@GetMapping("")
	public List<User> getUsers() {
		return this.userService.getUsers();
	}
	
	@GetMapping("/{userId}")
	public User getUsers(@PathVariable("userId") String userId) {
		return this.userService.getUserWithId(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateUserWithId(
			@PathVariable("userId") String userId,
			@RequestBody User user) {
		return this.userService.updateUserWithId(userId, user);
	}
	

}
