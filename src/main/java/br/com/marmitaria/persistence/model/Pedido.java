package br.com.marmitaria.persistence.model;

import java.io.Serializable;
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
public class Pedido implements Serializable,Comparable<Pedido>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 700394598617912892L;

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

	@Override
	public int compareTo(Pedido o) {
		return (int) (o.getIdPedido() - this.getIdPedido());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((marmita == null) ? 0 : marmita.hashCode());
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
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		if (marmita == null) {
			if (other.marmita != null)
				return false;
		} else if (!marmita.equals(other.marmita))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", marmita=" + marmita + ", produtos=" + produtos + "]";
	}
	
}
