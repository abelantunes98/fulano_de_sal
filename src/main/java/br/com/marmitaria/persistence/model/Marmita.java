package br.com.marmitaria.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MARMITA")
public class Marmita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarmita;
	
	@NotNull
	@Column(name = "VALOR",updatable = false)
	private float valor;
	
	@NotNull
	@Column(name = "TIPO_MARMITA")
	private TipoMarmita tipoMarmita;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	public Long getIdMarmita() {
		return idMarmita;
	}
	
	public void setIdMarmita(Long idMarmita) {
		this.idMarmita = idMarmita;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public TipoMarmita getTipoMarmita() {
		return tipoMarmita;
	}
	
	public void setTipoMarmita(TipoMarmita tipoMarmita) {
		this.tipoMarmita = tipoMarmita;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Marmita(float valor,TipoMarmita tipoMarmita,String descricao) {
		super();
		this.valor = valor;
		this.tipoMarmita = tipoMarmita;
		this.descricao = descricao;
	}
	
	public Marmita() {}
}
