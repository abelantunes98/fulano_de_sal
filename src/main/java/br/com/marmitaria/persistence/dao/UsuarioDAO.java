package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

}
