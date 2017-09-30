package com.stfo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stfo.models.PickedCards;

@Repository
public interface PickedCardsRepository extends MongoRepository<PickedCards, String> {

}
