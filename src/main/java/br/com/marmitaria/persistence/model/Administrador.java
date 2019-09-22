package br.com.marmitaria.persistence.model;


import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.marmitaria.rest.request.UsuarioRequest;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6173907806379226164L;
	
	
	public Administrador(UsuarioRequest request) {
		setNome(request.getNome());
		setEmail(request.getEmail());
		setSenha(request.getSenha());
		setTipo(TipoUsuario.ADMINISTRADOR);
		setCadastroPendente(false);
	}
	
	public Administrador(){}
	
}
