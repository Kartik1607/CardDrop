package com.stfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.helper.Constants;
import com.stfo.models.Registrations;
import com.stfo.models.User;
import com.stfo.models.decorated.UserRegistrationDecorated;
import com.stfo.models.decorated.UserRegistrationRequest;
import com.stfo.models.decorated.UserRegistrationResponse;
import com.stfo.services.RegistrationsService;
import com.stfo.services.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RegistrationsService registrationsService;
	
	@PostMapping("/login")
	public UserRegistrationResponse loginUser(@RequestBody UserRegistrationRequest request) {
		UserRegistrationResponse response = new UserRegistrationResponse();
		if(this.registrationsService.doesUserExists(request.getPhone())) {
			Registrations registration = this.registrationsService.loginUser(
											new Registrations(request.getPhone(), request.getPassword())
											);
			if (registration == null) {
				response.setStatus(Constants.INVALID_PASSWORD);
				response.setUser(null);
			} else {
				response.setStatus(Constants.SUCCESS_LOGIN);
				response.setUser(getUsers(registration.getUserId()));
			}
			return response;
		}
		
		response.setStatus(Constants.NOT_REGISTERED);
		response.setUser(null);
		return response;
	}
	
	@PostMapping("/register")
	public UserRegistrationResponse regusterUser(@RequestBody UserRegistrationRequest request) {
		UserRegistrationResponse response = new UserRegistrationResponse();
		if(this.registrationsService.doesUserExists(request.getPhone())) {
			response.setStatus(Constants.ALREADY_REGISTERED);
			response.setUser(null);
			return response;
		}
		
		User newUser = new User("","",request.getPhone(), "");
		newUser = this.userService.addUser(newUser);
		this.registrationsService.saveUser(newUser, request.getPassword());
		
		response.setStatus(Constants.NEW_REGISTRATION);
		response.setUser(newUser);
		return response;
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
