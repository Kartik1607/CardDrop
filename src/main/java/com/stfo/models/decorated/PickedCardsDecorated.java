package com.stfo.models.decorated;

import com.stfo.models.PickedCards;
import com.stfo.models.User;

public class PickedCardsDecorated {
	private PickedCards pickedCard;
	
	private User dropperUser;
	
	public PickedCardsDecorated(PickedCards pickedCard, User dropperUser) {
		this.pickedCard = pickedCard;
		this.dropperUser = dropperUser;
	}

	public PickedCards getPickedCard() {
		return pickedCard;
	}

	public void setPickedCard(PickedCards pickedCard) {
		this.pickedCard = pickedCard;
	}

	public User getDropperUser() {
		return dropperUser;
	}

	public void setDropperUser(User dropperUser) {
		this.dropperUser = dropperUser;
	}
	
	
}
