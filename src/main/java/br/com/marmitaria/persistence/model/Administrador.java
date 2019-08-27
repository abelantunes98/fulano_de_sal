package br.com.marmitaria.persistence.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
public class Administrador extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6173907806379226164L;

}
