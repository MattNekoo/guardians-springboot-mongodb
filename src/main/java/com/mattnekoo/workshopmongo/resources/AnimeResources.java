package com.mattnekoo.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mattnekoo.workshopmongo.entities.Anime;
import com.mattnekoo.workshopmongo.resources.util.URL;
import com.mattnekoo.workshopmongo.services.AnimeService;

@RestController
@RequestMapping(value = "/animes")
public class AnimeResources {

	@Autowired
	private AnimeService service;

	@GetMapping
	public ResponseEntity<List<Anime>> findAll() {
		List<Anime> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable String id) {
		Anime obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Anime> insert(@RequestBody Anime obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Anime> update(@PathVariable String id, @RequestBody Anime obj) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Anime>> findByTitle(@RequestParam(value = "title", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Anime> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
