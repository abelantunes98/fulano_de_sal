package br.com.marmitaria.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.model.Pedido;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Long>{

	List<Pedido> findAllByCliente(Cliente cliente);

}
