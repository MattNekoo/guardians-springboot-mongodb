package com.mattnekoo.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mattnekoo.workshopmongo.entities.Filme;

public interface FilmeRepository extends MongoRepository<Filme, String> {

}
