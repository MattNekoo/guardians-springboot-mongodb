package com.mattnekoo.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mattnekoo.workshopmongo.entities.Filme;

public interface FilmeRepository extends MongoRepository<Filme, String> {

	@Query("{nomeFilme : ?0}")    // SQL Equivalent : SELECT * FROM FILME where nomeFilme = ?
    List<Filme> getFilmByTitle(String nomeFilme);
}
