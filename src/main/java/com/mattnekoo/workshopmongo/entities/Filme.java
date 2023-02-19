package com.mattnekoo.workshopmongo.entities;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nomeFilme;
	private String dscFilme;
	private Integer anoFilme;

	public Filme() {
	}

	public Filme(String id, String nomeFilme, String dscFilme, Integer anoFilme) {
		super();
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

	public String getnomeFilme() {
		return nomeFilme;
	}

	public void setnomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getdscFilme() {
		return dscFilme;
	}

	public void setdscFilme(String dscFilme) {
		this.dscFilme = dscFilme;
	}

	public Integer getanoFilme() {
		return anoFilme;
	}

	public void setanoFilme(Integer anoFilme) {
		this.anoFilme = anoFilme;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoFilme, dscFilme, id, nomeFilme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(anoFilme, other.anoFilme) && Objects.equals(dscFilme, other.dscFilme)
				&& Objects.equals(id, other.id) && Objects.equals(nomeFilme, other.nomeFilme);
	}
}
