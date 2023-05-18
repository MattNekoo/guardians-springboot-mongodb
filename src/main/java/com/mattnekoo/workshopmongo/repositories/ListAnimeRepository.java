package com.mattnekoo.workshopmongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mattnekoo.workshopmongo.entities.ListAnime;

public interface ListAnimeRepository extends MongoRepository<ListAnime, String> {
    Optional<ListAnime> findByColecao(String colecao);
}

