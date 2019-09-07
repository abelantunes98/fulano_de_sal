package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Recuperacao;
import br.com.marmitaria.persistence.model.Usuario;

@Repository
public interface RecuperacaoDAO extends JpaRepository<Recuperacao, Long>{

	@Query("select r from Recuperacao r where r.usuario = :usuario")
	Recuperacao findByUsuario(@Param("usuario") Usuario usuario);
	
}
