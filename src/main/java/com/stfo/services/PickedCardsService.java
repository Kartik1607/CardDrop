package com.stfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stfo.repositories.PickedCardsRepository;

@Service
public class PickedCardsService {

	private PickedCardsRepository pickedCardsRepository;
	
	@Autowired
	public PickedCardsService(PickedCardsRepository pickedCardsRepository) {
		this.pickedCardsRepository = pickedCardsRepository;
	}
	
}
