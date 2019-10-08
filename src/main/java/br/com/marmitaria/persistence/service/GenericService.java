package br.com.marmitaria.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public class GenericService<T> {
	
	@Autowired
	private JpaRepository<T, Long> dao;
	
	public T salvar(T entity) {
		return dao.save(entity);
	}
	
	public T atualizar(T entity) {
		return dao.save(entity);
	}

	public void deletar(T entity) {
		dao.delete(entity);
	}
	
	public T findById(Long id) {
		return dao.findById(id).get();
	}
	
	public List<T> findAll() {
		return dao.findAll();
	}

}
