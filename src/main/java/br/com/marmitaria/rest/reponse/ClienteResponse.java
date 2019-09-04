package br.com.marmitaria.rest.reponse;

import br.com.marmitaria.persistence.model.Cliente;

public class ClienteResponse extends UsuarioResponse{
	
	private boolean cadastroPendente;
	
	private String endereco;
	

	public ClienteResponse(Cliente cliente, String token) {
		super(cliente,cliente.isCadastroPendente()?null:token);
		this.endereco = cliente.getEndereco();
		this.cadastroPendente = cliente.isCadastroPendente();
	}


	public boolean isCadastroPendente() {
		return cadastroPendente;
	}


	public void setCadastroPendente(boolean cadastroPendente) {
		this.cadastroPendente = cadastroPendente;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
