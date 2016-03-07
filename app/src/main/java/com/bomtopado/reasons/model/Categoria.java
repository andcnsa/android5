package com.bomtopado.reasons.model;

import android.content.Context;

import java.io.Serializable;

/**
 * Created by Anderson on 07/03/2016.
 */
public class Categoria implements Serializable{
    private int imagem;
    private int foto;
    private String titulo;
    private String descricao;
    private String texto;

    public Categoria(){}
    public Categoria(Context context, int titulo_resource, int descricao_resource, int texto_resource){
        setTitulo(context.getString(titulo_resource));
        setDescricao(context.getString(descricao_resource));
        setTexto(context.getString(texto_resource));
        setImagem(-1);
    }
    public Categoria(Context context, int titulo_resource, int descricao_resource, int texto_resource, int imagem_resource, int photo_resource){
        setTitulo(context.getString(titulo_resource));
        setDescricao(context.getString(descricao_resource));
        setTexto(context.getString(texto_resource));
        setFoto(photo_resource);
        setImagem(imagem_resource);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
