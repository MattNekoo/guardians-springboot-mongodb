package com.mattnekoo.workshopmongo.resources;

import com.mattnekoo.workshopmongo.entities.*;
import com.mattnekoo.workshopmongo.entities.PendenciaAnime;
import com.mattnekoo.workshopmongo.repositories.AnimeRepository;
import com.mattnekoo.workshopmongo.services.AnimeService;
import com.mattnekoo.workshopmongo.services.PendenciaAnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pendencia-anime")
public class PendenciaAnimeResources {

	@Autowired
	private PendenciaAnimeService service;

	@Autowired
	private AnimeRepository animeRepository;

	@GetMapping
	public ResponseEntity<List<PendenciaAnime>> findAll() {
		List<PendenciaAnime> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PendenciaAnime> findById(@PathVariable String id) {
		PendenciaAnime obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value = "/{animeID}")
	public ResponseEntity<PendenciaAnime> insert(@PathVariable String animeID, @RequestBody PendenciaAnime obj) {

		Optional<Anime> animeOptional = animeRepository.findById(animeID);
		if (!animeOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		PendenciaAnime objSalvo = service.insert(obj);

		Anime anime = animeOptional.get();
		anime.getPendencias().addAll(Arrays.asList(objSalvo));
		animeRepository.save(anime);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PendenciaAnime> update(@PathVariable String id, @RequestBody PendenciaAnime obj) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
