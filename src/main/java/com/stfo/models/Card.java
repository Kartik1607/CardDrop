package com.stfo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Card {

	@Id
	private String id;
	private int themeId;
	
}
