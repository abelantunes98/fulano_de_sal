package br.com.marmitaria.persistence.model;

public enum TipoPagamento {
	
	DINHEIRO("Dinheiro"),CARTAO("Cartão");
	
	private String valor;
	
	private TipoPagamento(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}

}
