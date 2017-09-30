package com.stfo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Mongo document to specify properties of a User.<br>
 * The model contains the details of a User, such as Name, Phone Number etc.<br>
 *
 * @author Kartik
 *
 */
@Document
public class User {

	/** MongoId of User. Used Internally. **/
	@Id
	private String id;
	
	/** Name of User **/
	private String name;
	
	/** Details a user wish to specify. **/
	private String detail;
	
	/** Phone Number of a User. It must be numeric. **/
	private long phone;
	
	/** Contains details of card user has created. **/
	private Card userCard;
	
	/**
	 * Returns the {@code mongoId} of the current User.
	 * <p>
	 * Use this to find {@link Drops} by the current User.
	 * @return String representing MongoId of User
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return String representing name of User.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return String representing details of User.
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @return String representing phone number of user.
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * @return Details of card of current User.
	 */
	public Card getUserCard() {
		return userCard;
	}

	/**
	 * Creates an instance of class User. <br>
	 * 
	 * @param name Set name of current User. {@link String#length()} of name must be <b>utmost 20 characters</b> long.
	 * @param detail  Sets details of current User. {@link String#length()} of details must be <b>utmost 50 characters</b> long.
	 * @param phone String representing phone number of user.
	 * @param userCard Details of card of current User.
	 * @throws IllegalArgumentException If a zero or negative phone number is given.
	 */
	public User(String name, String detail, long phone, Card userCard) throws IllegalArgumentException {
		super();
		this.name = name.substring(0,20);
		this.detail = detail.substring(0,50);
		if (phone <= 0) {
			throw new IllegalArgumentException("Phone number must be greater than zero");
		}
		this.phone = phone;
		this.userCard = userCard;
	}

}
