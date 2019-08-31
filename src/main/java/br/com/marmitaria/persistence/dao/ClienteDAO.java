package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

	Cliente findById(long id);
	
	Cliente findByEmail(String email);
}
