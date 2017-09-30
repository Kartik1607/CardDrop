package com.stfo.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Drops {
	
	@Id
	private String id;
	private String userId;
	private double latitude;
	private double longitude;
	private Date expireTime;
	

}
