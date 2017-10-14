package com.stfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stfo.models.Registrations;
import com.stfo.models.User;
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
		String password = org.apache.commons.codec.digest.DigestUtils.sha512Hex(registration.getPassword()).toString();
		return this.registrationsRepository.findByPhoneNumberAndPassword(
				registration.getPhoneNumber(), password
				);
		
	}
	
	public Registrations saveUser(User user, String password) {
		String digestPassword = org.apache.commons.codec.digest.DigestUtils.sha512Hex(password).toString();
		return this.registrationsRepository
				.save(new Registrations(user.getPhone(), digestPassword, user.getId()));
	}

}
