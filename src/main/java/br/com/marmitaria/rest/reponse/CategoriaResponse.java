package br.com.marmitaria.rest.reponse;

import java.io.Serializable;
import java.util.List;

import br.com.marmitaria.persistence.model.Categoria;

public class CategoriaResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2861280298685664940L;

	private String nome;
	
	private Long idCategoria;
	
	private List<ProdutoResponse> produtos;
	

	public CategoriaResponse(Categoria  categoria,List<ProdutoResponse> list) {
		this.nome = categoria.getDescricao();
		this.idCategoria = categoria.getId();
		this.produtos = list;
	}
	
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProdutoResponse> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoResponse> produtos) {
		this.produtos = produtos;
	}
}
