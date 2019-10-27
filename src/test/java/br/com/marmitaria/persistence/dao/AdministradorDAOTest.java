package br.com.marmitaria.persistence.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marmitaria.persistence.model.Administrador;

import br.com.marmitaria.rest.request.ClienteRequest;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class AdministradorDAOTest {

	@Autowired
	private AdministradorDAO repo;

	private ClienteRequest user;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		user = new ClienteRequest();
		user.setNome("Paulo");
		user.setTelefone("98555555");
		user.setEmail("paulo@gmail.com");
		user.setSenha("fulano");
		user.setEndereco("Rua da esquina");
	}

	/**
	 * Testa criar um administrador
	 */
	@Test
	public void criarAdministradorTest() {
		Administrador cliente = new Administrador(user);
		repo.save(cliente);

	}

}
