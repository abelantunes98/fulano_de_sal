package br.com.marmitaria.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.CategoriaDAO;
import br.com.marmitaria.persistence.model.Categoria;

@Service
public class CategoriaService extends GenericService<Categoria>{
	
	@Autowired
	private CategoriaDAO dao;

	public Categoria findByDescricao(String descricao) {
		return dao.findByDescricao(descricao);
	}

	
}
