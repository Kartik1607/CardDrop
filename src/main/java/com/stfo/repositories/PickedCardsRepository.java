package com.stfo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stfo.models.PickedCards;

import java.util.List;
@Repository
public interface PickedCardsRepository extends MongoRepository<PickedCards, String> {
	public List<PickedCards> findByPickerId(String pickerId);
}
