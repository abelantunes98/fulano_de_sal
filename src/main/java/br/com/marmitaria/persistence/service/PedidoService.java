package br.com.marmitaria.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.PedidoDAO;
import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.model.Pedido;

@Service
public class PedidoService extends GenericService<Pedido>{
	
	@Autowired
	private PedidoDAO dao;

	public List<Pedido> findByCliente(Cliente cliente) {
		return dao.findAllByCliente(cliente);
	}

	public List<Pedido> findByConfirmado(boolean b) {
		return dao.findByConfirmado(b);
	}

}
