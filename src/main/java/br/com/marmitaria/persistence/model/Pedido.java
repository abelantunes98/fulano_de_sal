package br.com.marmitaria.persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	private Long idPedido;
	
	public Long getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
}
