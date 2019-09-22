package br.com.marmitaria.rest.reponse;

import br.com.marmitaria.persistence.model.TipoUsuario;
import br.com.marmitaria.persistence.model.Usuario;

public class UsuarioResponse {
	
	private String nome;
	
	private String email;
	
	private TipoUsuario tipo;
	
	private String token;

	public UsuarioResponse(Usuario usuario, String token) {
		this.token = token;
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.tipo = usuario.getTipo();
	}
	
	public TipoUsuario getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

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

}
