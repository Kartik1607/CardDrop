package com.stfo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PickedCards {

	@Id
	String id;
	
	String pickerId;
	User dropperUser;
}
