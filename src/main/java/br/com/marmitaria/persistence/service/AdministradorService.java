package br.com.marmitaria.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.AdministradorDAO;
import br.com.marmitaria.persistence.model.Administrador;

@Service
public class AdministradorService extends GenericService<Administrador>{
	
	@Autowired
	private AdministradorDAO dao;

	public Administrador findByEmail(String email) {
		return dao.findByEmail(email);
	}

}
