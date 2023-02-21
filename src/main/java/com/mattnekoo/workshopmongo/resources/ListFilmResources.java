package com.mattnekoo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattnekoo.workshopmongo.entities.ListFilm;
import com.mattnekoo.workshopmongo.services.ListFilmService;

@RestController
@RequestMapping(value = "/listas")
public class ListFilmResources {

	@Autowired
	private ListFilmService service;

	@GetMapping
	public ResponseEntity<List<ListFilm>> findAll() {
		List<ListFilm> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ListFilm> findById(@PathVariable String id) {
		ListFilm obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
