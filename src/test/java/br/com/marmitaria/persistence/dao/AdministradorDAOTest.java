package br.com.marmitaria.persistence.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marmitaria.persistence.model.Administrador;

import br.com.marmitaria.rest.request.UsuarioRequest;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class AdministradorDAOTest {

	@Autowired
	private AdministradorDAO repositorioAdministradores;

	private UsuarioRequest usuario;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		usuario = new UsuarioRequest();
		usuario.setNome("Paulo");
		usuario.setEmail("paulo@gmail.com");
		usuario.setSenha("fulano");
	}

	/**
	 * Testa criar um administrador
	 */
	@Test
	public void criarAdministradorTest() {
		Administrador cliente = new Administrador(usuario);
		repositorioAdministradores.save(cliente);

	}

}
