package br.com.marmitaria.rest.request;

import java.io.Serializable;

public class CategoriaRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5010839314817221548L;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String nome) {
		this.descricao = nome;
	}
	
}
