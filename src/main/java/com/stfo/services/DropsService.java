package com.stfo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.stereotype.Service;

import com.stfo.helper.Constants;
import com.stfo.models.Drops;
import com.stfo.models.User;
import com.stfo.models.decorated.DropsDecorated;
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
	private UserService userService;
	
	@Autowired
	public DropsService(DropsRepository dropsRepository) {
		this.dropsRepository = dropsRepository;
	}
	
	/**
	 * Add a new card to Drops document and also calculates correct expire time.
	 * @param drop Drops object containing location, userId and expire_code.
	 * @return Newly created Drops document.
	 */
	public Drops addCardDrop(Drops drop) {
		drop.setExpireAt(Constants.getExpireTime(drop.getExpire_code()));
		System.out.println(drop.getExpireAt());
		return this.dropsRepository.save(drop);
	}
	
	/**
	 * Returns List of card dropped by a particular user.
	 * @param userId Mongo User Id for which cards are needed.
	 * @return All Cards dropped by user.
	 */
	public List<Drops> getCardsDroppedByUser(String userId) {
		return this.dropsRepository.findByUserId(userId);
	}
	
	/**
	 * Returns all the cards and users details who dropped a card within radius.
	 * @param latitude Current position of Client
	 * @param longitude Current position of Client
	 * @param radius Radius for which cards are needed
	 * @return List of {@link DropsDecorated}
	 */
	public List<DropsDecorated> getNearByCards(double latitude, double longitude, double radius) {
		List<DropsDecorated> ret = new ArrayList<>();
		this.dropsRepository.findByLocationWithin(new Circle(latitude, longitude, radius))
			.forEach( drop -> {
				User user = this.userService.getUserWithId(drop.getUserId());
				ret.add(new DropsDecorated(drop, user));
			});
		return ret;
	}
	
}
