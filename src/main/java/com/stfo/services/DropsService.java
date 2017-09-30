package com.stfo.services;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

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
	
	private enum EXPIRE_TIME { 
		TIME_SHORT, TIME_LONG;
	};

	private DropsRepository dropsRepository;
	
	@Autowired
	public DropsService(DropsRepository dropsRepository) {
		this.dropsRepository = dropsRepository;
	}
	
	private LocalDateTime getExpireTime(EXPIRE_TIME which) {
		LocalDateTime time = LocalDateTime.now();
		switch (which) {
			case TIME_SHORT: {
				time.plusMinutes(5);
				break;
			}
			case TIME_LONG: {
				time.plusYears(1);
				break;
			}
		}
		return time;
	}
	
}
