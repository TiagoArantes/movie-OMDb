package com.example.tiago.testezup;

import android.graphics.Bitmap;

/**
 * Created by Tiago on 10/02/2018.
 */

public class Filme {
    private String filme;
    private String ano;
    private String tempo;
    private String genero;
    private String diretor;
    private String escritor;
    private String atores;
    private String descricao;
    private String linguagem;
    private String pais;
    private String premios;
    private String urlImagem;
    private String imdb;
    private String tipo;
    private Bitmap poster;
    private String resposta;
    private String erro;

    public Filme(){}

    public Filme(String filme, String ano, String descricao){
        this.filme = filme;
        this.ano = ano;
        this.descricao = descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public Bitmap getPoster() {
        return poster;
    }

    public void setPoster(Bitmap poster) {
        this.poster = poster;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFilme() {return filme;}
    public String getAno() {return ano;}
    public String getDescricao() {return descricao;}
    public void setFilme(String filme) {this.filme = filme;}
    public void setAno(String ano) {this.ano = ano;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}
