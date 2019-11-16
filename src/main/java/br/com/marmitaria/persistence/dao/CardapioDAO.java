package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marmitaria.persistence.model.Cardapio;

public interface CardapioDAO extends JpaRepository<Cardapio, Long>{

	Cardapio findByLiberado(boolean liberado);

}
