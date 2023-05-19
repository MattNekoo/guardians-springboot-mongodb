package com.mattnekoo.workshopmongo.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class PendenciaAnime {
    private String id;
    private String nome;
    private Number ano;

    @DBRef
    private Anime anime;

    public PendenciaAnime(String id, String nome, Number ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Number getAno() {
        return ano;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(Number ano) {
        this.ano = ano;
    }
}
