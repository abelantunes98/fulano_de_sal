package br.com.marmitaria.persistence.model;

public enum TipoMarmita {	
	TRADICIONAL("TRADICIONAL"), DIVISORIA("DIVISORIA");
	
	private String valor;
	
	private TipoMarmita(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
