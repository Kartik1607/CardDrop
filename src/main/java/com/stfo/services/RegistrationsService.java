package com.stfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stfo.models.Registrations;
import com.stfo.models.User;
import com.stfo.models.decorated.UserRegistrationDecorated;
import com.stfo.repositories.RegistrationsRepository;

@Service
public class RegistrationsService {

	private RegistrationsRepository registrationsRepository;
	
	@Autowired
	public RegistrationsService(RegistrationsRepository registrationsRepository) {
		this.registrationsRepository = registrationsRepository;
	}
	
	public boolean doesUserExists(Long phoneNumber) {
		return this.registrationsRepository.findByPhoneNumber(phoneNumber) != null ;
	}
	
	public Registrations loginUser(Registrations registration) {
		return this.registrationsRepository.findByPhoneNumberAndPassword(
				registration.getPhoneNumber(), registration.getPassword()
				);
		
	}
	
	public Registrations saveUser(User user, String password) {
		return this.registrationsRepository
				.save(new Registrations(user.getPhone(), password, user.getId()));
	}

}
