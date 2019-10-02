package br.com.marmitaria.rest.request;

import java.io.Serializable;

public class ProdutoRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1319682749302829844L;
	
	private Long idProduto;
	private String nome;
	private Long idCategoria;
	
	public Long getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
}
