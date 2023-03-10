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

import com.mattnekoo.workshopmongo.entities.Filme;
import com.mattnekoo.workshopmongo.resources.util.URL;
import com.mattnekoo.workshopmongo.services.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeResources {

	@Autowired
	private FilmeService service;

	@GetMapping
	public ResponseEntity<List<Filme>> findAll() {
		List<Filme> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Filme> findById(@PathVariable String id) {
		Filme obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Filme> insert(@RequestBody Filme obj) {
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
	public ResponseEntity<Filme> update(@PathVariable String id, @RequestBody Filme obj) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Filme>> findByTitle(@RequestParam(value = "title", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Filme> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
