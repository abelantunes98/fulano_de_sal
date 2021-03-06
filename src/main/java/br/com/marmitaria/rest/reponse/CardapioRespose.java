package br.com.marmitaria.rest.reponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.marmitaria.persistence.model.Cardapio;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.rest.util.DateUtils;

public class CardapioRespose implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2402454664555277237L;
	
	private String data;
	private List<CategoriaResponse> categorias;
	private boolean liberado;
	
	
	public CardapioRespose(Cardapio cardapio) {
		this.data = DateUtils.newDate(cardapio.getData());
		this.liberado = cardapio.isLiberado();
		Map<Categoria, List<ProdutoResponse>> produtos  = new HashMap<Categoria, List<ProdutoResponse>>();
		categorias = new ArrayList<>();
		for(Produto produto:cardapio.getProdutos()) {
			Categoria categoria = produto.getCategoria();
			if(produtos.get(categoria)==null) {
				produtos.put(categoria, new ArrayList<ProdutoResponse>());
			}
			produtos.get(categoria).add(new ProdutoResponse(produto));
		}
		
		for(Categoria key: produtos.keySet()){
			categorias.add(new CategoriaResponse(key,produtos.get(key)));
		}
	}
	
	
	public boolean isLiberado() {
		return liberado;
	}
	
	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public List<CategoriaResponse> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<CategoriaResponse> categorias) {
		this.categorias = categorias;
	}

}
