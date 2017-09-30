package com.stfo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stfo.models.Drops;

@Repository
public interface DropsRepository extends MongoRepository<Drops, String>{

}
