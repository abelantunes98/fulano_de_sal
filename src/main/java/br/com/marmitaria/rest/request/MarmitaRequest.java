package br.com.marmitaria.rest.request;

import java.io.Serializable;


public class MarmitaRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7993846437279750939L;
	private Long id;
	private String tipo;
	private float valor;
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
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
}
