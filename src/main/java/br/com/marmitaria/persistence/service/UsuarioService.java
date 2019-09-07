package br.com.marmitaria.persistence.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.UsuarioDAO;
import br.com.marmitaria.persistence.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	
	public Usuario create(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	public Usuario findByEmail(String email) {
		return usuarioDao.findByEmail(email);
	}

	public Usuario update(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

}
