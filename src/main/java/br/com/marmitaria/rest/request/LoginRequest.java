package br.com.marmitaria.rest.request;

import java.io.Serializable;

public class LoginRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7532798577159280448L;

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

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
