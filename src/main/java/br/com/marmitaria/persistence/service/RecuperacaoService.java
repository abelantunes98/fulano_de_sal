package br.com.marmitaria.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.RecuperacaoDAO;
import br.com.marmitaria.persistence.model.Recuperacao;
import br.com.marmitaria.persistence.model.Usuario;

@Service
public class RecuperacaoService {
	
	@Autowired
	private RecuperacaoDAO dao;

	public Recuperacao create(Recuperacao recuperacao) {
		return dao.save(recuperacao);
	}
	
	public Recuperacao findByUsuario(Usuario usuario) {
		return dao.findByUsuario(usuario);
	}

	public Recuperacao update(Recuperacao recuperacao) {
		return dao.save(recuperacao);
		
	}

	public void delete(Recuperacao recuperacao) {
		dao.delete(recuperacao);
	}
	
}
