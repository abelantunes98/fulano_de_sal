package br.com.marmitaria.rest.request;


public class ClienteRequest extends UsuarioRequest{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2560992207941608841L;

	
	
	private String endereco;

	private String telefone;
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
