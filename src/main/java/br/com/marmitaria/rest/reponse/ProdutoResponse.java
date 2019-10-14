package br.com.marmitaria.rest.reponse;

import java.io.Serializable;

import br.com.marmitaria.persistence.model.Produto;

public class ProdutoResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1088739676673009105L;
	
	private Long id;
	private String nome;
	
	public ProdutoResponse(Produto produto) {
		this.nome = produto.getNome();
		this.id = produto.getIdProduto();
	}
	
	public ProdutoResponse() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
