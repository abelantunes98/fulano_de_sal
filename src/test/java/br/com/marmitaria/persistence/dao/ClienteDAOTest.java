package br.com.marmitaria.persistence.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marmitaria.persistence.model.Cliente;

import br.com.marmitaria.rest.request.ClienteRequest;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class ClienteDAOTest {

	@Autowired
	private ClienteDAO repo;

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
	 * Testa criar um cliente 
	 */
	@Test
	public void criarClienteTest() {
		Cliente cliente = new Cliente(user);
		repo.save(cliente);
		assertThat(repo.findByEmail("paulo@gmail.com").getSenha()).isEqualTo("fulano");
		assertThat(repo.count()).isEqualTo(1);
	}

	/**
	 * Testa criar um cliente com endereço nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarClienteEnderecoNuloTest() {
		user.setEndereco(null);
		Cliente cliente = new Cliente(user);
		repo.save(cliente);

	}
	
	/**
	 * Testa criar um cliente com endereço vazio
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarClienteEnderecoVazioTest() {
		user.setEndereco("");
		Cliente cliente = new Cliente(user);
		repo.save(cliente);

	}
	/**
	 * Testa atualizar endereço de um cliente
	 */
	@Test(expected = ConstraintViolationException.class)
	public void atualizarEnderecoClienteTest() {
		user.setEndereco("");
		Cliente cliente = new Cliente(user);
		repo.save(cliente);

	}

}
