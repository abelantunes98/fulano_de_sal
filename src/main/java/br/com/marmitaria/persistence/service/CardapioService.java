package br.com.marmitaria.persistence.service;

import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.CardapioDAO;
import br.com.marmitaria.persistence.model.Cardapio;

@Service
public class CardapioService extends GenericService<Cardapio> {
	
	private CardapioDAO DAO;

	public Cardapio findByLiberado(boolean liberado) {
		return DAO.findByLiberado(liberado);
	}

}
