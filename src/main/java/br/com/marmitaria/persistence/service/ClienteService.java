package br.com.marmitaria.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.ClienteDAO;
import br.com.marmitaria.persistence.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDAO dao;

	public Cliente create(Cliente cliente) {
		return dao.save(cliente);
	}
	
	public Cliente findById(Long id) {
		return dao.findById((long)id);
	}

	public Cliente findByEmail(String email) {
		return dao.findByEmail(email);
	}

}
