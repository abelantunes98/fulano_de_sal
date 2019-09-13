package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Administrador;

@Repository
public interface AdministradorDAO extends JpaRepository<Administrador, Long> {

	Administrador findByEmail(String email);

}
