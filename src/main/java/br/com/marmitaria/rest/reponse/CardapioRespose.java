package br.com.marmitaria.rest.reponse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	private String data;
	private List<CategoriaResponse> categorias;
	
	
	public CardapioRespose(Cardapio cardapio) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.data = dateFormat.format(cardapio.getData());
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
