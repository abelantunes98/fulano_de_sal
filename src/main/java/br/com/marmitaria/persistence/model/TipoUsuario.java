package br.com.marmitaria.persistence.model;

public enum TipoUsuario {
	
	ADMINISTRADOR("ADMINISTRADOR"),CLIENTE("CLIENTE");
	
	private String valor;
	
	private TipoUsuario(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

}
