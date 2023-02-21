package com.mattnekoo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mattnekoo.workshopmongo.entities.Filme;
import com.mattnekoo.workshopmongo.repositories.FilmeRepository;
import com.mattnekoo.workshopmongo.services.exception.DatabaseException;
import com.mattnekoo.workshopmongo.services.exception.ObjectNotFoundException;
import com.mattnekoo.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;

	public List<Filme> findAll() {
		return repository.findAll();
	}

	public Filme findById(String id) {
		Optional<Filme> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	/* INSERT FILME */
	public Filme insert(Filme obj) {
		return repository.save(obj);
	}

	/* DELETE FILME */
	public void delete(String id) {
		try {
			repository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	/* UPDATE FILME */
	public Filme update(Filme obj) {
		try {
			Optional<Filme> newObj = repository.findById(obj.getId());
			Filme filme = newObj.get();
			updateData(filme, obj);
			return repository.save(filme);			
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}

	// AUXILIAR METHOD FOR FILME UPDATE
	private void updateData(Filme entity, Filme obj) {
		entity.setnomeFilme(obj.getnomeFilme());
		entity.setanoFilme(obj.getanoFilme());
		entity.setdscFilme(obj.getdscFilme());
	}
}
