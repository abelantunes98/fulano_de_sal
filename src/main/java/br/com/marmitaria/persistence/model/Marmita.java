package br.com.marmitaria.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marmita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarmita;
	
	public Long getIdMarmita() {
		return idMarmita;
	}
	
	public void setIdMarmita(Long idMarmita) {
		this.idMarmita = idMarmita;
	}

}
