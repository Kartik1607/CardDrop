package com.stfo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * Drops Class is used to store model of a user who has dropped a card.
 * <br>
 * It contains information which tells <b>which</b> user has dropped a card, <b>when</b> the card will expire
 * and <b>where</b> the card was dropped,
 * @author Kartik
 *
 */
@Document
public class Drops {
	
	/**
	 * MongoId of Drop. For internal use.
	 */
	@Id
	private String id;
	/**
	 * Mongo UserId of user who has dropped the card.
	 */
	private String userId;
	
	/**
	 * Expire Type of Card. 5 min or 1 year?
	 */
	private int expire_code;
	
	/**
	 * GeoLocation where the card was dropped.
	 */
	private double[] location;
	
	
	/**
	 * When will the card expire? Computed internally through expire_code.
	 */
	@Field
	@Indexed(expireAfterSeconds=0)
	private LocalDateTime expireAt;

	/**
	 * Constructs object of Drop type.
	 * @param userId Mongo userId of User who has dropped the card
	 * @param expire_code 0 = Expire after 5 minute <br> 1 = Expire after 1 year
	 * @param location GeoLocation of user.
	 */
	public Drops(String userId, int expire_code, double[] location) {
		this.userId = userId;
		this.location = location;
		this.expire_code = expire_code;
	}
	
	/**
	 * Constructs object of Drop type.
	 */
	public Drops() {
		
	}
	
	/**
	 * @return expire_code 0 = Expire after 5 minute <br> 1 = Expire after 1 year
	 */
	public int getExpire_code() {
		return expire_code;
	}

	/**
	 * @return MongoId of Drop
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return MongoId of User
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return GeoLocation of Card Drop
	 */
	public double[] getLocation() {
		return location;
	}

	/**
	 * @return Card Expire Date/Time
	 */
	public LocalDateTime getExpireAt() {
		return expireAt;
	}

	/**
	 * @param id MongoId to be set. Internal use only.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param userId MongoId of User. 
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param location GeoLocation of user
	 */
	public void setLocation(double[] location) {
		this.location = location;
	}

	/**
	 * @param expireAt Date/Time when the card will expire. Computed through Expire Code.
	 */
	public void setExpireAt(LocalDateTime expireAt) {
		this.expireAt = expireAt;
	}
	
	
		 
}
