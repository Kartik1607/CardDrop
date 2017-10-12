package com.stfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.models.PickedCards;
import com.stfo.models.decorated.PickedCardsDecorated;
import com.stfo.services.PickedCardsService;

@CrossOrigin
@RequestMapping("/api/pickedCards")
@RestController
public class PickedCardsController {

	@Autowired
	private PickedCardsService pickedCardsService;
	
	@PostMapping("")
	public PickedCards addCard(@RequestBody PickedCards pickedCard) {
		return this.pickedCardsService.addCard(pickedCard);
	}
	
	@GetMapping("/{userId}")
	public List<PickedCardsDecorated> getCardsPickedByUserId(@PathVariable("userId") String userId) {
		return this.pickedCardsService.getCardsPickedByUserId(userId);
	}
}
