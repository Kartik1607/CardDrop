package com.stfo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stfo.models.Registrations;

@Repository
public interface RegistrationsRepository extends MongoRepository<Registrations, String> {
	public Registrations findByPhoneNumber(Long phoneNumber);
	public Registrations findByPhoneNumberAndPassword(Long phoneNumber, String password);
}
