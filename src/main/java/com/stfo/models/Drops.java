package com.stfo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Drops {
	
	
	@Id
	private String id;
	private String userId;
	
	private int expire_code;
	
	private double[] location;
	
	@Field
	@Indexed(expireAfterSeconds=0)
	private LocalDateTime expireAt;

	public Drops(String userId, int expire_code, double[] location) {
		this.userId = userId;
		this.location = location;
		this.expire_code = expire_code;
	}
	
	public Drops() {
		
	}
	
	public int getExpire_code() {
		return expire_code;
	}

	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public double[] getLocation() {
		return location;
	}

	public LocalDateTime getExpireAt() {
		return expireAt;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public void setExpireAt(LocalDateTime expireAt) {
		this.expireAt = expireAt;
	}
	
	
		 
}
