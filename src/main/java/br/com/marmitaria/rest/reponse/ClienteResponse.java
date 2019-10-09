package br.com.marmitaria.rest.reponse;

import br.com.marmitaria.persistence.model.Cliente;

public class ClienteResponse extends UsuarioResponse{
	
	private boolean cadastroPendente;
	
	private String endereco;
	
	private String senha;

	private String telefone;

	public ClienteResponse(Cliente cliente, String token) {
		super(cliente,cliente.isCadastroPendente()?null:token);
		this.endereco = cliente.getEndereco();
		this.cadastroPendente = cliente.isCadastroPendente();
		this.senha = "ola";
		this.telefone = cliente.getTelefone();
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
	
	public String getSenha() {
		return senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public String setTelefone(String newTelefone) {
		this.telefone = newTelefone;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
