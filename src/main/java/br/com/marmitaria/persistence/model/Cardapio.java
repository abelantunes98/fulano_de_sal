package br.com.marmitaria.persistence.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "CARDAPIO")
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARDAPIO")
	private Long idCardapio;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CARDAPIO_PRODUTO", joinColumns = { @JoinColumn(name = "ID_CARDAPIO") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_PRODUTO") })
	private Set<Produto> produtos;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CARDAPIO")
	private Date data;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MARMITA")
	private Marmita marmita;
	

	public Marmita getMarmita() {
		return marmita;
	}

	public void setMarmita(Marmita marmita) {
		this.marmita = marmita;
	}

	public Long getIdCardapio() {
		return idCardapio;
	}

	public void setIdCardapio(Long idCardapio) {
		this.idCardapio = idCardapio;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
