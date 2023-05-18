package com.mattnekoo.workshopmongo.entities;

import java.util.List;

public class AnimeGroup {
	private String colecao;
	private List<Anime> animes;
	
	public String getColecao() {
		return colecao;
	}
	public void setColecao(String colecao) {
		this.colecao = colecao;
	}
	public List<Anime> getAnimes() {
		return animes;
	}
	public void setAnimes(List<Anime> animes) {
		this.animes = animes;
	}

	
}
