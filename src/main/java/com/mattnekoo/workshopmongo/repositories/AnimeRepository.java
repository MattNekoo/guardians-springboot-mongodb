package com.mattnekoo.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mattnekoo.workshopmongo.entities.Anime;

public interface AnimeRepository extends MongoRepository<Anime, String> {

	@Query("{nomeAnime : ?0}")    // SQL Equivalent : SELECT * FROM FILME where nomeFilme = ?
    List<Anime> getAnimeByTitle(String nomeAnime);
}
