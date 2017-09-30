package com.stfo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Drops {
	
	@Id
	private String id;
	private String userId;
	
	private GeoJsonPoint location;
	
	@Field
	@Indexed(expireAfterSeconds=0)
	private LocalDateTime expireAt;

	public Drops(String userId, GeoJsonPoint location, LocalDateTime expireAt) {
		super();
		this.userId = userId;
		this.location = location;
		this.expireAt = expireAt;
	}

	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public GeoJsonPoint getLocation() {
		return location;
	}

	public LocalDateTime getExpireAt() {
		return expireAt;
	}
		 
}
