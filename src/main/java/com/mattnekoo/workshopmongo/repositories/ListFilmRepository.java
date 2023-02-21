package com.mattnekoo.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mattnekoo.workshopmongo.entities.ListFilm;

public interface ListFilmRepository extends MongoRepository<ListFilm, String> {
	
}

