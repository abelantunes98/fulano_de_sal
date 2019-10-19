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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
	@JoinColumn(name = "ID_MARMITA")
	private Marmita marmita;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PEDIDO_PRODUTO",joinColumns = {@JoinColumn(name="ID_PEDIDO")},inverseJoinColumns = {@JoinColumn(name="ID_PRODUTO")})
	private List<Produto> produtos;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USUARIO")
	private Cliente cliente;
	
	@Column(name = "CONFIRMADO")
	private Boolean confirmado;
	
	@Column(name = "OBSERVACOES")
	private String obsvacoes;

	@NotNull
	@Column(name = "TIPO_PAGAMENTO")
	private TipoPagamento tipoPagamento;
	
	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date  data;
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	
	public String getObsvacoes() {
		return obsvacoes;
	}
	
	public void setObsvacoes(String obsvacoes) {
		this.obsvacoes = obsvacoes;
	}
	
	public Marmita getMarmita() {
		return marmita;
	}

	public void setMarmita(Marmita marmita) {
		this.marmita = marmita;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
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

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}
	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((confirmado == null) ? 0 : confirmado.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((marmita == null) ? 0 : marmita.hashCode());
		result = prime * result + ((obsvacoes == null) ? 0 : obsvacoes.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + ((tipoPagamento == null) ? 0 : tipoPagamento.hashCode());
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
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (confirmado == null) {
			if (other.confirmado != null)
				return false;
		} else if (!confirmado.equals(other.confirmado))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
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
		if (obsvacoes == null) {
			if (other.obsvacoes != null)
				return false;
		} else if (!obsvacoes.equals(other.obsvacoes))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (tipoPagamento != other.tipoPagamento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", marmita=" + marmita + ", produtos=" + produtos + ", cliente="
				+ cliente + ", confirmado=" + confirmado + ", obsvacoes=" + obsvacoes + ", tipoPagamento="
				+ tipoPagamento + ", data=" + data + "]";
	}
	
}
