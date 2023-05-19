package com.mattnekoo.workshopmongo.services;

import com.mattnekoo.workshopmongo.entities.Filme;
import com.mattnekoo.workshopmongo.entities.PendenciaAnime;
import com.mattnekoo.workshopmongo.repositories.PendenciaAnimeRepository;
import com.mattnekoo.workshopmongo.services.exception.DatabaseException;
import com.mattnekoo.workshopmongo.services.exception.ObjectNotFoundException;
import com.mattnekoo.workshopmongo.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PendenciaAnimeService {

	@Autowired
	private PendenciaAnimeRepository repository;

	public List<PendenciaAnime> findAll() {
		return repository.findAll();
	}

	public PendenciaAnime findById(String id) {
		Optional<PendenciaAnime> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public PendenciaAnime insert(PendenciaAnime obj) {
		return repository.save(obj);
	}

	public PendenciaAnime update(PendenciaAnime obj) {
		try {
			Optional<PendenciaAnime> newObj = repository.findById(obj.getId());
			PendenciaAnime pendenciaAnime = newObj.get();
			updateData(pendenciaAnime, obj);
			return repository.save(pendenciaAnime);
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

	private void updateData(PendenciaAnime entity, PendenciaAnime obj) {
		entity.setNome(obj.getNome());
		entity.setAno(obj.getAno());
	}
}
