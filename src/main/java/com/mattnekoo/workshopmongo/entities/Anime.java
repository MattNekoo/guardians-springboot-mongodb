package com.mattnekoo.workshopmongo.entities;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Anime implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nomeAnime;
	private String tipoAnime;
	private Integer anoAnime;
	private Integer epiAnime;
	private Double scoreAnime;
	private Integer notaAnime;

	public Anime() {
	}

	public Anime(String id, String nomeAnime, String tipoAnime, Integer anoAnime, Integer epiAnime, double scoreAnime,
			Integer notaAnime) {
		this.id = id;
		this.nomeAnime = nomeAnime;
		this.tipoAnime = tipoAnime;
		this.anoAnime = anoAnime;
		this.epiAnime = epiAnime;
		this.scoreAnime = scoreAnime;
		this.notaAnime = notaAnime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getnomeAnime() {
		return nomeAnime;
	}

	public void setnomeAnime(String nomeAnime) {
		this.nomeAnime = nomeAnime;
	}

	public String gettipoAnime() {
		return tipoAnime;
	}

	public void settipoAnime(String tipoAnime) {
		this.tipoAnime = tipoAnime;
	}

	public Integer getanoAnime() {
		return anoAnime;
	}

	public void setanoAnime(Integer anoAnime) {
		this.anoAnime = anoAnime;
	}
	
	public Integer getEpiAnime() {
		return epiAnime;
	}

	public void setEpiAnime(Integer epiAnime) {
		this.epiAnime = epiAnime;
	}

	public Double getScoreAnime() {
		return scoreAnime;
	}

	public void setScoreAnime(Double scoreAnime) {
		this.scoreAnime = scoreAnime;
	}

	public Integer getNotaAnime() {
		return notaAnime;
	}

	public void setNotaAnime(Integer notaAnime) {
		this.notaAnime = notaAnime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anime other = (Anime) obj;
		return Objects.equals(id, other.id);
	}
}
