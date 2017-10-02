package com.stfo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stfo.models.PickedCards;
import com.stfo.models.User;
import com.stfo.models.decorated.PickedCardsDecorated;
import com.stfo.repositories.PickedCardsRepository;

@Service
public class PickedCardsService {

	private PickedCardsRepository pickedCardsRepository;
	@Autowired
	private UserService userService;
	
	@Autowired
	public PickedCardsService(PickedCardsRepository pickedCardsRepository) {
		this.pickedCardsRepository = pickedCardsRepository;
	}
	
	public PickedCards addCard(PickedCards pickedCard) {
		return this.pickedCardsRepository.save(pickedCard);
	}
	
	public List<PickedCardsDecorated> getCardsPickedByUserId(String userId) {
		List<PickedCardsDecorated> ret = new ArrayList<>();
		this.pickedCardsRepository.findByPickerId(userId)
			.forEach( pickedCard -> {
				User user = this.userService.getUserWithId(pickedCard.getDropperId());
				ret.add(new PickedCardsDecorated(pickedCard, user));
			});
		return ret;
	}
}
