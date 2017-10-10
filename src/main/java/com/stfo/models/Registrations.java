package com.stfo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Mongo Doucment to save all the Registered Users.
 * 
 * @author Kartik
 */
@Document
public class Registrations {

	/**
	 * MongoId of Registration
	 */
	@Id
	private String id;
	
	/**
	 * PhoneNumber through which user registered.
	 */
	@Field
	@Indexed
	private Long phoneNumber;
	
	/**
	 * Hash Digest of Password of User
	 */
	private String password;
	
	/**
	 * Mongo UserId of User.
	 */
	private String userId;
	
	/**
	 * Constructs a new instance of Registration.
	 */
	public Registrations() {}

	
	/**
	 * Constructs a new instance of Registration.
	 * @param phoneNumber PhoneNumber through which user registered.
	 * @param password Hash Digest of Password of User
	 * @param userId Mongo UserId of User.
	 */
	public Registrations(Long phoneNumber, String password, String userId) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userId = userId;
	}
	
	/**
	 * Constructs a new instance of Registration.
	 * @param phoneNumber PhoneNumber through which user registered.
	 * @param password Hash Digest of Password of User
	 */
	public Registrations(Long phoneNumber, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	/**
	 * @return String representing mongoId of Registration.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @return PhoneNumber through which user registered.
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * @return Hash Digest of Password of User
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return userId Mongo UserId of User.
	 */
	public String getUserId() {
		return userId;
	}
	
}
