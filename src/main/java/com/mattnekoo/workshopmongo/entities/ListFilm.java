package com.mattnekoo.workshopmongo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.mattnekoo.workshopmongo.dto.UserListDTO;

public class ListFilm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String dscList;
	private UserListDTO usuario;

	@DBRef(lazy = true)
	private List<Filme> filmes = new ArrayList<>();

	public ListFilm() {
	}

	public ListFilm(String id, String dscList, UserListDTO usuario) {
		super();
		this.id = id;
		this.dscList = dscList;
		this.usuario = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserListDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UserListDTO usuario) {
		this.usuario = usuario;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public String getDscList() {
		return dscList;
	}

	public void setDscList(String dscList) {
		this.dscList = dscList;
	}
}
