package com.mattnekoo.workshopmongo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mattnekoo.workshopmongo.entities.ListAnime;

@Repository
public interface ListAnimeRepository extends MongoRepository<ListAnime, String> {
    Optional<ListAnime> findByColecao(String colecao);

    List<ListAnime> findAll(Sort sort);
}
