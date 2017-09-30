package com.stfo.models;

import java.util.List;

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
	private String phone;
	
	/** Contains mongoId of card user has created. **/
	private String userCard;
	
	/** List of mongoId's of drops, which are picked by current user. **/
	private List<String> pickedCards;

	/**
	 * Returns the {@code mongoId} of the Current User.
	 * <p>
	 * Use this to find {@link Drops} by the current User.
	 * @return String representing MongoId of User
	 */
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserCard() {
		return userCard;
	}

	public void setUserCard(String userCard) {
		this.userCard = userCard;
	}

	public List<String> getPickedCards() {
		return pickedCards;
	}

	public void setPickedCards(List<String> pickedCards) {
		this.pickedCards = pickedCards;
	}
	
	
	
	
}
