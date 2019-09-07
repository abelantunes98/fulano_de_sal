package br.com.marmitaria.rest.request;

import java.io.Serializable;

public class UsuarioRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3224723877526001078L;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
