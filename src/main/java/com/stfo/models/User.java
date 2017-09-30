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
	 * Set name of current User. {@link String#length()} of name must be <b>utmost 20 characters</b> long.
	 * @param name New name for current User
	 */
	public void setName(String name) {
		if (name.length() <= 20) {
			this.name = name;
		}
	}

	/**
	 * @return String representing details of User.
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * Sets details of current User. {@link String#length()} of details must be <b>utmost 50 characters</b> long.
	 * @param detail
	 */
	public void setDetail(String detail) {
		if (detail.length() <= 50) {
			this.detail = detail;
		}
	}

	/**
	 * @return String representing phone number of user.
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * Sets phone number of current User.
	 * <p>
	 *  
	 * @param phone Phone number of User.
	 * @throws IllegalArgumentException If a zero or negative phone number is given.
	 */
	public void setPhone(long phone) throws IllegalArgumentException{
		if (phone <= 0) {
			throw new IllegalArgumentException("Phone number must be greater than zero");
		}
		this.phone = phone;
	}

	/**
	 * @return Details of card of current User.
	 */
	public Card getUserCard() {
		return userCard;
	}

	/**
	 * Sets card of current User.
	 * @param userCard The new card to replace current user card.
	 */
	public void setUserCard(Card userCard) {
		this.userCard = userCard;
	}

	public User(String name, String detail, long phone, Card userCard) {
		super();
		this.name = name;
		this.detail = detail;
		this.phone = phone;
		this.userCard = userCard;
	}

}
