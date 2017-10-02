package com.stfo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.stereotype.Service;

import com.stfo.helper.Constants;
import com.stfo.models.Drops;
import com.stfo.repositories.DropsRepository;

/**
 * <b>DropsService</b> is responsible for managing the events and queries related the user dropping his/her card.
 * <br>For example : Adding a new card to document, getting list of dropped cards etc.
 * @author Kartik
 *
 */
@Service
public class DropsService {	
	
	private DropsRepository dropsRepository;
	
	@Autowired
	public DropsService(DropsRepository dropsRepository) {
		this.dropsRepository = dropsRepository;
	}
	
	
	public Drops addCardDrop(Drops drop) {
		drop.setExpireAt(Constants.getExpireTime(drop.getExpire_code()));
		System.out.println(drop.getExpireAt());
		return this.dropsRepository.save(drop);
	}
	
	public List<Drops> getCardsDroppedByUser(String userId) {
		return this.dropsRepository.findById(userId);
	}
	
	public List<Drops> getNearByCards(double latitude, double longitude, double radius) {
		return this.dropsRepository.findByLocationWithin(new Circle(latitude, longitude, radius));
	}
	
}
