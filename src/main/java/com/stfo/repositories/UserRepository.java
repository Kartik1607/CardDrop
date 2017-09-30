package com.stfo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stfo.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
