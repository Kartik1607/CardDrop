package com.stfo.models.decorated;

import com.stfo.helper.Constants;
import com.stfo.models.User;

/**
 * Class to send Response for registration along with status and user if created.
 * @author Kartik
 * @see Constants
 */
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
