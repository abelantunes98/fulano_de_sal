package br.com.marmitaria.persistence.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.UsuarioDAO;
import br.com.marmitaria.persistence.model.Usuario;

@Service
public class UsuarioService extends GenericService<Usuario>{
	
	@Autowired
	private UsuarioDAO dao;
	
	public Usuario findByEmail(String email) {
		return dao.findByEmail(email);
	}
}
