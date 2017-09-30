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

@Service
public class DropsService {

	private DropsRepository dropsRepository;
	
	@Autowired
	public DropsService(DropsRepository dropsRepository) {
		this.dropsRepository = dropsRepository;
	}
	
	/*public void test() {
		LocalDateTime date = LocalDateTime.now();
		date = date.plusSeconds(5);
		dropsRepository.save(new Drops("123", new GeoJsonPoint(new Point(0, 0)), date));
		date = date.plusMinutes(1);
		dropsRepository.save(new Drops("123", new GeoJsonPoint(new Point(0, 0)), date));
	}*/
}
