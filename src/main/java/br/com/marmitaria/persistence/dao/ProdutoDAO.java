package br.com.marmitaria.persistence.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long>{

	Produto findByNome(String nome);

	List<Produto> findByCategoria(Categoria categoria);

}
