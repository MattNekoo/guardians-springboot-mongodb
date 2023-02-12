package com.mattnekoo.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mattnekoo.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}

