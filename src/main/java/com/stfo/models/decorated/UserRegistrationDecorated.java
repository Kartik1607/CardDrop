package com.stfo.models.decorated;

import com.stfo.models.User;

/**
 * 
 * @author Kartik
 *
 */
public class UserRegistrationDecorated {
	private Long phone;
	private String password;
	
	public UserRegistrationDecorated(Long phone, String password) {
		this.phone = phone;
		this.password = password;
	}

	public Long getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}
	
	
}
