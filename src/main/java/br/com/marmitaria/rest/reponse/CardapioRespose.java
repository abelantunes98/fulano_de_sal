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
	private List<CategoriaResponse> categorias;
	
	
	public CardapioRespose(Cardapio cardapio) {
		this.data = cardapio.getData();
		Map<String, List<ProdutoResponse>> produtos  = new HashMap<String, List<ProdutoResponse>>();
		
		categorias = new ArrayList<>();
		for(Produto produto:cardapio.getProdutos()) {
			Categoria categoria = produto.getCategoria();
			if(produtos.get(categoria.getDescricao())==null) {
				produtos.put(categoria.getDescricao(), new ArrayList<ProdutoResponse>());
			}
			produtos.get(categoria.getDescricao()).add(new ProdutoResponse(produto));
		}
		
		for(String key: produtos.keySet()){
			categorias.add(new CategoriaResponse(produtos.get(key)));
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<CategoriaResponse> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<CategoriaResponse> categorias) {
		this.categorias = categorias;
	}

}
