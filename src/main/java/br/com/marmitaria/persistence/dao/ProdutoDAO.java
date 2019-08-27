package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long>{

}
