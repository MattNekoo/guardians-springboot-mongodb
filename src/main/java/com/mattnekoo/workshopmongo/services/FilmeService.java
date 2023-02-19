package com.mattnekoo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattnekoo.workshopmongo.entities.Filme;
import com.mattnekoo.workshopmongo.repositories.FilmeRepository;
import com.mattnekoo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;

	public List<Filme> findAll() {
		return repository.findAll();
	}

	public Filme findById(String id) {
		Optional<Filme> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Filme insert(Filme obj) {
		return repository.save(obj);
	}

}
