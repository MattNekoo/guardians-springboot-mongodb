package com.mattnekoo.workshopmongo.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.mattnekoo.workshopmongo.dto.UserListDTO;

public class ListFilm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String dscList;
	private UserListDTO usuario;
	
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

	public String getDscList() {
		return dscList;
	}

	public void setDscList(String dscList) {
		this.dscList = dscList;
	}

	public UserListDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UserListDTO usuario) {
		this.usuario = usuario;
	}
}
