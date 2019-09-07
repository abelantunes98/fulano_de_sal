package br.com.marmitaria.rest.request;

import java.io.Serializable;

public class ConfirmacaoDeCodigoRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3083227644913530859L;
	
	private String email;
	
	private String codigo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
