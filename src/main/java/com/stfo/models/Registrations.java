package com.stfo.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Registrations {

	private String id;
	@Field
	@Indexed
	private Long phoneNumber;
	private String password;
	private String userId;
	
	public Registrations() {}

	public Registrations(Long phoneNumber, String password, String userId) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userId = userId;
	}
	
	public Registrations(Long phoneNumber, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}
	
}
