package br.com.marmitaria.rest.request;

import java.io.Serializable;


public class MarmitaRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7993846437279750939L;
	private String tipo;
	private float valor;
	
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
