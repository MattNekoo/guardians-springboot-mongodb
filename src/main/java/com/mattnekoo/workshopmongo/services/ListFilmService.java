package com.mattnekoo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattnekoo.workshopmongo.entities.ListFilm;
import com.mattnekoo.workshopmongo.repositories.ListFilmRepository;
import com.mattnekoo.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class ListFilmService {

	@Autowired
	private ListFilmRepository repository;

	public List<ListFilm> findAll() {
		return repository.findAll();
	}

	public ListFilm findById(String id) {
		Optional<ListFilm> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
