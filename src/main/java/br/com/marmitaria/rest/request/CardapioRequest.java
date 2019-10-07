package br.com.marmitaria.rest.request;

import java.io.Serializable;
import java.util.Set;

public class CardapioRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 318940916330669090L;
	
	private Set<Long> idProdutos;
	
	private Long  idMarmita;

	public Set<Long> getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(Set<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}

	public Long getIdMarmita() {
		return idMarmita;
	}

	public void setIdMarmita(Long idMarmita) {
		this.idMarmita = idMarmita;
	}

	
}
