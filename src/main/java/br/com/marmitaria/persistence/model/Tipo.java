package br.com.marmitaria.persistence.model;

public enum Tipo {
	
	ADMINISTRADOR("ADMINISTRADOR"),CLIENTE("CLIENTE");
	
	private String valor;
	
	private Tipo(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

}
