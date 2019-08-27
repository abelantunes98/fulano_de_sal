package br.com.marmitaria.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cardapio {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long idCardapio;
	
	public Long getIdCardapio() {
		return idCardapio;
	}
	
	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
	}

}
