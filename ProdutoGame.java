package com.lojaGames.lojaGames.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ProdutoGame {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@NotBlank
	@Size(min = 3, max = 255) 
	private String nome;
	
	@NotBlank
	@Size(min = 3, max = 1500)
	private String descricao;
	
	@Size(min = 3, max = 255)
	private String imagem;
	
	
	@ManyToOne
	@JsonIgnoreProperties("produtogame")
	private CategoriaGame categoriaGame;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public CategoriaGame getCategoriaGame() {
		return categoriaGame;
	}


	public void setCategoriaGame(CategoriaGame categoriaGame) {
		this.categoriaGame = categoriaGame;
	}


	
}
