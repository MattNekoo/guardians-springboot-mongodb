package com.mattnekoo.workshopmongo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class ListAnime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String colecao;

	@DBRef(lazy = true)
	private List<Anime> anime = new ArrayList<>();

	public ListAnime() {
	}

	public ListAnime(String id, String colecao) {
		super();
		this.id = id;
		this.colecao = colecao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColecao() {
		return colecao;
	}

	public void setColecao(String colecao) {
		this.colecao = colecao;
	}
	
	public List<Anime> getAnimes() {
		return anime;
	}

	public void setAnimes(List<Anime> anime) {
		this.anime = anime;
	}
}
