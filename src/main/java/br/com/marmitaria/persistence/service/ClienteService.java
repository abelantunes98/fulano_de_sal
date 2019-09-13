package br.com.marmitaria.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.ClienteDAO;
import br.com.marmitaria.persistence.model.Cliente;

@Service
public class ClienteService extends GenericService<Cliente>{
	
	@Autowired
	private ClienteDAO dao;

	public Cliente findByEmail(String email) {
		return dao.findByEmail(email);
	}
}
