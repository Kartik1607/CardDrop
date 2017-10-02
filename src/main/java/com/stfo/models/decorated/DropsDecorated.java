package com.stfo.models.decorated;

import com.stfo.models.Drops;
import com.stfo.models.User;

public class DropsDecorated  {

	private User user;
	private Drops drop;
	
	public DropsDecorated(Drops drop, User user) {
		this.drop = drop;
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	public Drops getDrop() {
		return drop;
	}
	
}
