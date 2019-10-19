package br.com.marmitaria.rest.reponse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.Pedido;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.persistence.model.TipoPagamento;

public class PedidoResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3462969514983599362L;

	private Marmita marmita;

	private Map<String, List<ProdutoResponse>> produtos;

	private Boolean confirmado;

	private Long idPedido;

	private String observacoes;

	private TipoPagamento tipoPagamento;
	
	private Cliente cliente;
	
	private String data;

	public PedidoResponse(Pedido pedido) {
		this.marmita = pedido.getMarmita();
		this.confirmado = pedido.getConfirmado();
		this.idPedido = pedido.getIdPedido();
		this.observacoes = pedido.getObsvacoes();
		this.tipoPagamento = pedido.getTipoPagamento();
		this.cliente = pedido.getCliente();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.data = format.format(pedido.getData());
		produtos = new HashMap<>();
		for (Produto produto : pedido.getProdutos()) {
			if (produtos.get(produto.getCategoria().getDescricao()) == null) {
				produtos.put(produto.getCategoria().getDescricao(), new ArrayList<ProdutoResponse>());
			}

			produtos.get(produto.getCategoria().getDescricao()).add(new ProdutoResponse(produto));
		}
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Marmita getMarmita() {
		return marmita;
	}

	public void setMarmita(Marmita marmita) {
		this.marmita = marmita;
	}

	public Map<String, List<ProdutoResponse>> getProdutos() {
		return produtos;
	}

	public void setProdutos(Map<String, List<ProdutoResponse>> produtos) {
		this.produtos = produtos;
	}

}
