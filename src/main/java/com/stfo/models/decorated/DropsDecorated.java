package com.stfo.models.decorated;

import com.stfo.models.Drops;
import com.stfo.models.User;

/**
 * Class to store the populated user with help of user id from drops document.
 * @author Kartik
 * @see Drops
 * @see User
 *
 */
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
