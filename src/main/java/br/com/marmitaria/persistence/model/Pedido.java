package br.com.marmitaria.persistence.model;

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

@Entity
@Table(name = "PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PEDIDO")
	private Long idPedido;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Marmita marmita;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PEDIDO_PRODUTO",joinColumns = {@JoinColumn(name="ID_PEDIDO")},inverseJoinColumns = {@JoinColumn(name="ID_PRODUTO")})
	private Set<Produto> produtos;
	
	
	public Marmita getMarmita() {
		return marmita;
	}

	public void setMarmita(Marmita marmita) {
		this.marmita = marmita;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
}
