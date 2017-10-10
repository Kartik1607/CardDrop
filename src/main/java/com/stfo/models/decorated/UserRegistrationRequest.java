package com.stfo.models.decorated;

/**
 * Class to get a Request specifically for Login.
 * @author Kartik
 *
 */
public class UserRegistrationRequest {
	
	private Long phone;
	private String password;
	
	public UserRegistrationRequest(Long phone, String password) {
		super();
		this.phone = phone;
		this.password = password;
	}

	public UserRegistrationRequest() {
		super();
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
