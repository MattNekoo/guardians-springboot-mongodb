package com.mattnekoo.workshopmongo.repositories;

import com.mattnekoo.workshopmongo.entities.PendenciaAnime;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PendenciaAnimeRepository extends MongoRepository<PendenciaAnime, String> {
	
}

