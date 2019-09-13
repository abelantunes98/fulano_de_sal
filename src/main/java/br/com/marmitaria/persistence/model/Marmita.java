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
	@Column(name = "VALOR",updatable = false,unique = true)
	private float valor;
	
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
}
