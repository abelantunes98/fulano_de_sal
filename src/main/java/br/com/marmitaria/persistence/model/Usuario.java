package br.com.marmitaria.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8813205038502530616L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String nome;
	
	@NotNull
	@Column
	private String email;
	
	@NotNull
	@Column
	private String senha;
	
	@Column
	@NotNull
	private Tipo tipo;
	
	@Column
	private boolean cadastroPendente;
		

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public boolean isCadastroPendente() {
		return cadastroPendente;
	}
	
	public void setCadastroPendente(boolean cadastroPendente) {
		this.cadastroPendente = cadastroPendente;
	}

	@Override
	public String toString() {
		return String.format("{nome:%s, email: %s}", this.nome,this.email);
	}

}
