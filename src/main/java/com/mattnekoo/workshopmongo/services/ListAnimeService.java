package com.mattnekoo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mattnekoo.workshopmongo.entities.ListAnime;
import com.mattnekoo.workshopmongo.repositories.ListAnimeRepository;
import com.mattnekoo.workshopmongo.services.exception.DatabaseException;
import com.mattnekoo.workshopmongo.services.exception.ObjectNotFoundException;
import com.mattnekoo.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class ListAnimeService {

	@Autowired
	private ListAnimeRepository repository;

	public List<ListAnime> findAll() {
		return repository.findAll();
	}

	public ListAnime findById(String id) {
		Optional<ListAnime> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public ListAnime insert(ListAnime obj) {
	    try {
	            Optional<ListAnime> existingCollection = repository.findByColecao(obj.getColecao());

	            if (existingCollection.isPresent()) {
	                ListAnime collection = existingCollection.get();
	                collection.getAnimes().addAll(obj.getAnimes());

	                return repository.save(collection);
	            } else {
	                return repository.save(obj);
	            }
	        } catch (NoSuchElementException e) {
	            throw new ObjectNotFoundException("Objeto não encontrado");
	        }
	}

	public ListAnime update(ListAnime obj) {
	    try {
	            Optional<ListAnime> existingCollection = repository.findByColecao(obj.getColecao());

	            if (existingCollection.isPresent()) {
	            	
	                ListAnime collection = existingCollection.get();
	                collection.getAnimes().addAll(obj.getAnimes());
	                
	                return repository.save(collection);
	            } else {
	                return repository.save(obj);
	            }
	        } catch (NoSuchElementException e) {
	            throw new ObjectNotFoundException("Objeto não encontrado");
	        }
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
