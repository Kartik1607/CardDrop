package com.stfo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * PickedCards Mongo document contains all the cards picked by 
 * the users.
 * 
 * <p>
 * Using this document we can filter out cards picked by a specific user.
 * <br>
 * Example object in MongoDB
 * <blockquote><pre>
 * 
 * {
 * 	"id": "1", 
 * 	"pickerId": "12",
 * 	"dropperId": "54",
 * }
 * 
 * </pre>
 * </blockquote>
 * 
 * This indicates that a user with {@code pickerId = 12} picked up card of user of {@code dropperId = 54}.
 * <br>
 * The details of dropperUser is provided to reduce server requests.
 * <br>To find all the cards picked by {@code pickerId = 12} simply do a {@code findByPickerId("12")}
 *  
 * @author Kartik
 *
 */
@Document
public class PickedCards {

	/** MongoId of the picked card. Internal Use only. **/
	@Id
	private String id;
	
	/** MongoId of user who picked the card. **/
	@Indexed
	private String pickerId;
	
	/** MongoId of user who dropped the card which was picked by other user. **/
	private String dropperId;

	/**
	 * Creates an instance of Class PickedCards.<br>
	 * The instance is a single element which had been retrieved or will be added to a {@code PickedCards} document.
	 * @param pickerId Id of {@link User} who picked the card
	 * @param dropperId Id of {@link User} who dropped the card
	 */
	public PickedCards(String pickerId, String dropperId) {
		super();
		this.pickerId = pickerId;
		this.dropperId = dropperId;
	}

	/**
	 * @return String representing MongoId of current document element. For internal use only.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return String representing mongoId of {@link User} who picked the card
	 */
	public String getPickerId() {
		return pickerId;
	}

	/**
	 * @return String representing mongoId Id of {@link User} who dropped the card
	 */
	public String getDropperId() {
		return dropperId;
	}
	
}
