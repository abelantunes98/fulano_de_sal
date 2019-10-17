package br.com.marmitaria.rest.reponse;

import java.io.Serializable;
import java.util.List;

public class CategoriaResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2861280298685664940L;

	private String nome;
	
	private List<ProdutoResponse> produtos;

	public CategoriaResponse(String nome,List<ProdutoResponse> list) {
		this.nome = nome;
		this.produtos = list;
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
