package com.mattnekoo.workshopmongo.dto;

import java.io.Serializable;

public class FilmeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nomeFilme;
	private String dscFilme;
	private Integer anoFilme;

	public FilmeDTO() {
		
	}

	public FilmeDTO(String id, String nomeFilme, String dscFilme, Integer anoFilme) {
		this.id = id;
		this.nomeFilme = nomeFilme;
		this.dscFilme = dscFilme;
		this.anoFilme = anoFilme;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getDscFilme() {
		return dscFilme;
	}

	public void setDscFilme(String dscFilme) {
		this.dscFilme = dscFilme;
	}

	public Integer getAnoFilme() {
		return anoFilme;
	}

	public void setAnoFilme(Integer anoFilme) {
		this.anoFilme = anoFilme;
	}
	
}
