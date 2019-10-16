package br.com.marmitaria.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MARMITA")
public class Marmita implements Serializable, Comparable<Marmita>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3141095153121936116L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarmita;
	
	@NotNull
	@Column(name = "VALOR")
	private float valor;
	
	@NotNull
	@Column(name = "TIPO_MARMITA")
	private TipoMarmita tipoMarmita;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@NotNull
	@Column(name = "CARNES")
	private int carnes;
	
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
	
	public int getCarnes() {
		return carnes;
	}

	public void setCarnes(int carnes) {
		this.carnes = carnes;
	}

	public Marmita(float valor,TipoMarmita tipoMarmita,String descricao, int carnes) {
		super();
		this.valor = valor;
		this.tipoMarmita = tipoMarmita;
		this.descricao = descricao;
		this.carnes = carnes;
	}
	
	public Marmita() {}

	@Override
	public int compareTo(Marmita o) {
		return (int) (o.getIdMarmita() - this.getIdMarmita());
	}

	

	@Override
	public String toString() {
		return "Marmita [idMarmita=" + idMarmita + ", valor=" + valor + ", tipoMarmita=" + tipoMarmita + ", descricao="
				+ descricao + ", carnes=" + carnes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carnes;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idMarmita == null) ? 0 : idMarmita.hashCode());
		result = prime * result + ((tipoMarmita == null) ? 0 : tipoMarmita.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marmita other = (Marmita) obj;
		if (carnes != other.carnes)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idMarmita == null) {
			if (other.idMarmita != null)
				return false;
		} else if (!idMarmita.equals(other.idMarmita))
			return false;
		if (tipoMarmita != other.tipoMarmita)
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	
}
