package br.com.marmitaria.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.CardapioDAO;
import br.com.marmitaria.persistence.model.Cardapio;

@Service
public class CardapioService extends GenericService<Cardapio> {
	
	@Autowired
	private CardapioDAO DAO;

	public Cardapio findByLiberado(boolean liberado) {
		return DAO.findByLiberado(liberado);
	}

}
