package br.com.marmitaria.rest.reponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.marmitaria.persistence.model.Pedido;

public class PedidosResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6706552844246137285L;
	
	private List<PedidoResponse> pedidos;
	
	public PedidosResponse(List<Pedido> list) {
		this.pedidos = new ArrayList<PedidoResponse>();
		for(Pedido pedido: list){
			pedidos.add(new PedidoResponse(pedido));
		}
	}

	public List<PedidoResponse> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoResponse> pedidos) {
		this.pedidos = pedidos;
	}

}
