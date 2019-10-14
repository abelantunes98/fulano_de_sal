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
	private Map<Categoria, List<ProdutoResponse>> produtos;
	
	public CardapioRespose(Cardapio cardapio) {
		this.data = cardapio.getData();
		produtos  = new HashMap<Categoria, List<ProdutoResponse>>();
		for(Produto produto:cardapio.getProdutos()) {
			Categoria categoria = produto.getCategoria();
			if(produtos.get(categoria)==null) {
				produtos.put(categoria, new ArrayList<ProdutoResponse>());
			}
			produtos.get(categoria).add(new ProdutoResponse(produto));
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Map<Categoria, List<ProdutoResponse>> getProdutos() {
		return produtos;
	}

	public void setProdutos(Map<Categoria, List<ProdutoResponse>> produtos) {
		this.produtos = produtos;
	}
	
	

}
