package br.com.marmitaria.rest.request;

import java.io.Serializable;
import java.util.Set;

import br.com.marmitaria.persistence.model.TipoPagamento;

public class PedidoRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2613829712159550087L;
	
	private String email;
	
	private Long idMarmita;
	
	private Set<Long> idProdutos;
	
	private String observacoes;
	
	private TipoPagamento tipoPagamento;
	

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdMarmita() {
		return idMarmita;
	}

	public void setIdMarmita(Long idMarmita) {
		this.idMarmita = idMarmita;
	}

	public Set<Long> getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(Set<Long> idProdutos) {
		this.idProdutos = idProdutos;
	}

}
