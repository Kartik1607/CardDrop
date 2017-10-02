package com.stfo.repositories;

import java.util.List;

import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stfo.models.Drops;

@Repository
public interface DropsRepository extends MongoRepository<Drops, String>{
	
	List<Drops> findByUserId(String userId);
	List<Drops> findByLocationWithin(Circle circle);
}
