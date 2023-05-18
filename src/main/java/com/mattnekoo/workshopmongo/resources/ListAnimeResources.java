package com.mattnekoo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattnekoo.workshopmongo.entities.ListAnime;
import com.mattnekoo.workshopmongo.services.ListAnimeService;

@RestController
@RequestMapping(value = "/grupo-animes")
public class ListAnimeResources {

	@Autowired
	private ListAnimeService service;
	
	@GetMapping
	public ResponseEntity<List<ListAnime>> findAll() {
		List<ListAnime> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ListAnime> findById(@PathVariable String id) {
		ListAnime obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
