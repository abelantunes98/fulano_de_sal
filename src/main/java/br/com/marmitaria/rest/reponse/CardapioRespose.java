package br.com.marmitaria.rest.reponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.marmitaria.persistence.model.Cardapio;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;

public class CardapioRespose implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2402454664555277237L;
	
	private Date data;
	private Map<String, List<ProdutoResponse>> produtos;
	
	public CardapioRespose(Cardapio cardapio) {
		this.data = cardapio.getData();
		produtos  = new HashMap<String, List<ProdutoResponse>>();
		for(Produto produto:cardapio.getProdutos()) {
			Categoria categoria = produto.getCategoria();
			if(produtos.get(categoria.getDescricao())==null) {
				produtos.put(categoria.getDescricao(), new ArrayList<ProdutoResponse>());
			}
			produtos.get(categoria.getDescricao()).add(new ProdutoResponse(produto));
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Map<String, List<ProdutoResponse>> getProdutos() {
		return produtos;
	}

	public void setProdutos(Map<String, List<ProdutoResponse>> produtos) {
		this.produtos = produtos;
	}
	
	

}
