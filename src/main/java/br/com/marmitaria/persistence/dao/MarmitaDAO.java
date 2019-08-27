package br.com.marmitaria.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.marmitaria.persistence.model.Marmita;

@Repository
public interface MarmitaDAO extends JpaRepository<Marmita, Long>{

}
