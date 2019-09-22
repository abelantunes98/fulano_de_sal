package br.com.marmitaria.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.MarmitaDAO;
import br.com.marmitaria.persistence.model.Marmita;

@Service
public class MarmitaService extends GenericService<Marmita>{
	
	@Autowired
	private MarmitaDAO dao;
}
