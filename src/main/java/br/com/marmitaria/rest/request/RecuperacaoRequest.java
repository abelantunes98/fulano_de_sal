package br.com.marmitaria.rest.request;

import java.io.Serializable;

public class RecuperacaoRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6731842684628972466L;
	
	private String email;
	
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String codigo) {
		this.senha = codigo;
	}
	
	

}
