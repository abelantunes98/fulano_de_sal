package br.com.marmitaria.persistence.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.dao.ProdutoDAO;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;

@Service
public class ProdutoService extends GenericService<Produto>{
	
	@Autowired
	private ProdutoDAO dao;

	public Produto findByNome(String nome) {
		return dao.findByNome(nome);
	}

	public Set<Produto> findByCategoria(Categoria categoria) {
		return new HashSet<Produto>(dao.findByCategoria(categoria));
	}

}
