package com.bomtopado.reasons.model;

import android.content.Context;

import java.io.Serializable;

/**
 * Categoria é a classe enviada entre o HomeActivity e o CategoriaActivity
 * Created by Anderson on 07/03/2016.
 */
public class Categoria implements Serializable{
    private int imagem = -1;
    private int foto;
    private String titulo;
    private String descricao;
    private String texto;

    public Categoria(){}


    public String getTitulo() {
        return titulo;
    }

    public Categoria setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getTexto() {
        return texto;
    }

    public Categoria setTexto(String texto) {
        this.texto = texto;
        return this;
    }

    public int getImagem() {
        return imagem;
    }

    public Categoria setImagem(int imagem) {
        this.imagem = imagem;
        return this;
    }

    public int getFoto() {
        return foto;
    }

    public Categoria setFoto(int foto) {
        this.foto = foto;
        return this;
    }
}
