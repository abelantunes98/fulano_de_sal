package br.com.marmitaria.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "CARDAPIO")
public class Cardapio implements Serializable, Comparable<Cardapio>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5966910549929051635L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARDAPIO")
	private Long idCardapio;

	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "CARDAPIO_PRODUTO", joinColumns = { @JoinColumn(name = "ID_CARDAPIO") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_PRODUTO") })
	private List<Produto> produtos;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CARDAPIO")
	private Date data;
	
	@Column(name = "LIBERADO")
	private boolean liberado;
	
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "ID_MARMITA")
//	private Marmita marmita;
	

//	public Marmita getMarmita() {
//		return marmita;
//	}
//
//	public void setMarmita(Marmita marmita) {
//		this.marmita = marmita;
//	}
	


	public Long getIdCardapio() {
		return idCardapio;
	}

	public boolean isLiberado() {
		return liberado;
	}

	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}

	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int compareTo(Cardapio o) {
		return (int) (o.getIdCardapio() - this.getIdCardapio());
	}

	@Override
	public String toString() {
		return "Cardapio [idCardapio=" + idCardapio + ", produtos=" + produtos + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((idCardapio == null) ? 0 : idCardapio.hashCode());
		result = prime * result + (liberado ? 1231 : 1237);
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
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
		Cardapio other = (Cardapio) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idCardapio == null) {
			if (other.idCardapio != null)
				return false;
		} else if (!idCardapio.equals(other.idCardapio))
			return false;
		if (liberado != other.liberado)
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}

}
