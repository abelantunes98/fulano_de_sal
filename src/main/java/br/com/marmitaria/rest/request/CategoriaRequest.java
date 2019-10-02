package br.com.marmitaria.rest.request;

import java.io.Serializable;

public class CategoriaRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5010839314817221548L;
	
	private Long id;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String nome) {
		this.descricao = nome;
	}
	
}
