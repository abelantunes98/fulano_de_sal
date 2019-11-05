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
	private ClienteDAO repositorioClientes;

	private ClienteRequest clienteRequest;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		clienteRequest = new ClienteRequest();
		clienteRequest.setNome("Paulo");
		clienteRequest.setTelefone("98555555");
		clienteRequest.setEmail("paulo@gmail.com");
		clienteRequest.setSenha("fulano");
		clienteRequest.setEndereco("Rua da esquina");
	}
	/**
	 * Testa criar um cliente 
	 */
	@Test
	public void criarClienteTest() {
		Cliente cliente = new Cliente(clienteRequest);
		repositorioClientes.save(cliente);
		assertThat(repositorioClientes.findByEmail("paulo@gmail.com").getSenha()).isEqualTo("fulano");
		assertThat(repositorioClientes.count()).isEqualTo(1);
	}

	/**
	 * Testa criar um cliente com endereço nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarClienteEnderecoNuloTest() {
		clienteRequest.setEndereco(null);
		Cliente cliente = new Cliente(clienteRequest);
		repositorioClientes.save(cliente);

	}
	
	/**
	 * Testa criar um cliente com endereço vazio
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarClienteEnderecoVazioTest() {
		clienteRequest.setEndereco("");
		Cliente cliente = new Cliente(clienteRequest);
		repositorioClientes.save(cliente);

	}
	/**
	 * Testa atualizar endereço de um cliente
	 */
	@Test(expected = ConstraintViolationException.class)
	public void atualizarEnderecoClienteTest() {
		clienteRequest.setEndereco("");
		Cliente cliente = new Cliente(clienteRequest);
		repositorioClientes.save(cliente);

	}

}
