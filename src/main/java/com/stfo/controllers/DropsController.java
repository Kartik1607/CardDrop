package com.stfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stfo.models.Drops;
import com.stfo.models.decorated.DropsDecorated;
import com.stfo.services.DropsService;

@CrossOrigin
@RestController
@RequestMapping("/api/drops")
public class DropsController {
	@Autowired
	private DropsService dropsService;

	@GetMapping("/{userId}")
	public List<Drops> getCardsDroppedByUser(@PathVariable("userId") String userId) {
		return dropsService.getCardsDroppedByUser(userId);
	}
	
	@GetMapping("")
	public List<DropsDecorated> getNearByCards(
			@RequestParam("lat") double latitude,
			@RequestParam("long") double longitude,
			@RequestParam("radius") double radius
			) {
		return dropsService.getNearByCards(latitude, longitude, radius);
	}

	@PostMapping("")
	public Drops addCardDrop(@RequestBody Drops drop) {
		return dropsService.addCardDrop(drop);
	}
}
