package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Categoria;

@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Long>{

}
