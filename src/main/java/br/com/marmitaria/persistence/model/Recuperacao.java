package br.com.marmitaria.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RECUPERACAO")
public class Recuperacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8555087695352551922L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Usuario usuario;
	
	@Column
	@NotNull
	private String codigo;
	
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataCriacao;
	
	public Recuperacao() {}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public static class Builder{
	
		private Usuario usuario;
		private String codigo;
		private Date dataCriacao;
		
		public Builder setUsuario(Usuario usuario) {
			this.usuario = usuario;
			return this;
		}
		
		public Builder setCodigo(String codigo) {
			this.codigo = codigo;
			return this;
		}
		public Builder setDataCriacao(Date dataCriacao) {
			this.dataCriacao = dataCriacao;
			return this;
		}
		
		public Recuperacao build() {
			return new Recuperacao(this);
		}
	}
	
	public Recuperacao(Builder builder) {
		this.usuario = builder.usuario;
		this.codigo = builder.codigo;
		this.dataCriacao = builder.dataCriacao;
	}
}
