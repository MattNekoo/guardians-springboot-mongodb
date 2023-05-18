package com.mattnekoo.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mattnekoo.workshopmongo.entities.Anime;
import com.mattnekoo.workshopmongo.repositories.AnimeRepository;
import com.mattnekoo.workshopmongo.services.exception.DatabaseException;
import com.mattnekoo.workshopmongo.services.exception.ObjectNotFoundException;
import com.mattnekoo.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class AnimeService {

	@Autowired
	private AnimeRepository repository;

	public List<Anime> findAll() {
		return repository.findAll();
	}

	public Anime findById(String id) {
		Optional<Anime> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	/* INSERT ANIME */
	public Anime insert(Anime obj) {
		return repository.save(obj);
	}

	/* DELETE ANIME */
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/* UPDATE ANIME */
	public Anime update(Anime obj) {
		try {
			Optional<Anime> newObj = repository.findById(obj.getId());
			Anime anime = newObj.get();
			updateData(anime, obj);
			return repository.save(anime);
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}

	// AUXILIAR METHOD FOR ANIME UPDATE
	private void updateData(Anime entity, Anime obj) {
		entity.setnomeAnime(obj.getnomeAnime());
		entity.setanoAnime(obj.getanoAnime());
		entity.settipoAnime(obj.gettipoAnime());
		entity.setEpiAnime(obj.getEpiAnime());
		entity.setNotaAnime(obj.getNotaAnime());
		entity.setScoreAnime(obj.getScoreAnime());
		entity.setSequencia(obj.getSequencia());
	}

	public List<Anime> findByTitle(String title) {
		return repository.getAnimeByTitle(title);
	}
}
