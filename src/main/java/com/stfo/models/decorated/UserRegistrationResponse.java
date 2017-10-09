package com.stfo.models.decorated;

import com.stfo.models.User;

public class UserRegistrationResponse {
	private String status;
	private User user;

	public UserRegistrationResponse() {
		super();
	}

	public UserRegistrationResponse(String status, User user) {
		super();
		this.status = status;
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
