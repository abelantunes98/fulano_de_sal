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

import br.com.marmitaria.persistence.model.TipoUsuario;
import br.com.marmitaria.persistence.model.Usuario;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class UsuarioDAOTest {

	@Autowired
	private UsuarioDAO repo;

	private Usuario user;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		user = new Usuario();
		user.setTipo(TipoUsuario.CLIENTE);
		user.setNome("Paulo");
		user.setCadastroPendente(true);
		user.setEmail("paulo@gmail.com");
		user.setSenha("fulano");
		repo.save(user);

	}

	/**
	 * Testa criar um usuário do tipo Cliente
	 */
	@Test
	public void criarUsuarioClienteTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.CLIENTE);
		u.setNome("Eduardo");
		u.setCadastroPendente(true);
		u.setEmail("edu@gmail.com");
		u.setSenha("123456");
		repo.save(u);
		assertThat(repo.count()).isEqualTo(2);
		assertThat(repo.findByEmail("edu@gmail.com").getNome()).isEqualTo("Eduardo");
	}

	/**
	 * Testa criar um usuário do tipo Administrador
	 */
	@Test
	public void criarUsuarioAdministradorTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.ADMINISTRADOR);
		u.setNome("Eduardo");
		u.setCadastroPendente(true);
		u.setEmail("edu@gmail.com");
		u.setSenha("123456");
		repo.save(u);
		assertThat(repo.count()).isEqualTo(2);
		assertThat(repo.findByEmail("edu@gmail.com").getNome()).isEqualTo("Eduardo");
	}

	/**
	 * Testa criar um usuário com tipo nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarUsuarioTipoNuloTest() {
		Usuario u = new Usuario();
		u.setTipo(null);
		u.setNome("Eduardo");
		u.setCadastroPendente(true);
		u.setEmail("edu@gmail.com");
		u.setSenha("123456");
		repo.save(u);
		assertThat(repo.count()).isEqualTo(1);
		assertThat(repo.findByEmail("edu@gmail.com").getNome()).isEqualTo("Eduardo");
	}

	/**
	 * Testa criar um usuário com nome nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarUsuarioNomeNuloTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.ADMINISTRADOR);
		u.setNome(null);
		u.setCadastroPendente(true);
		u.setEmail("edu@gmail.com");
		u.setSenha("123456");
		repo.save(u);

	}

	/**
	 * Testa criar um usuário com nome vazio
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarUsuarioNomeVazioTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.ADMINISTRADOR);
		u.setNome("");
		u.setCadastroPendente(true);
		u.setEmail("edu@gmail.com");
		u.setSenha("123456");
		repo.save(u);

	}

	/**
	 * Testa criar um usuário com email nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarUsuarioEmailNuloTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.ADMINISTRADOR);
		u.setNome("Eduardo");
		u.setCadastroPendente(true);
		u.setEmail(null);
		u.setSenha("123456");
		repo.save(u);

	}

	/**
	 * Testa criar um usuário com email vazio
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarUsuarioEmailVazioTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.ADMINISTRADOR);
		u.setNome("Eduardo");
		u.setCadastroPendente(true);
		u.setEmail("");
		u.setSenha("123456");
		repo.save(u);

	}

	/**
	 * Testa criar um usuário com senha nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarUsuarioSenhaNulaTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.ADMINISTRADOR);
		u.setNome("Eduardo");
		u.setCadastroPendente(true);
		u.setEmail("edu@gmail.com");
		u.setSenha(null);
		repo.save(u);

	}

	/**
	 * Testa criar um usuário com senha vazia
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarUsuarioSenhaVaziaTest() {
		Usuario u = new Usuario();
		u.setTipo(TipoUsuario.ADMINISTRADOR);
		u.setNome("Eduardo");
		u.setCadastroPendente(true);
		u.setEmail("edu@gmail.com");
		u.setSenha("");
		repo.save(u);
	}

	/**
	 * Testa atualizar email de um usuário
	 */
	@Test
	public void atualizarEmailTest() {
		user.setEmail("edu@gmail.com");
		repo.save(user);
		assertThat(repo.findByEmail("paulo@gmail.com")).isNotNull();
		assertThat(repo.findByEmail("edu@gmail.com")).isNull();
	}

	/**
	 * Testa atualizar senha de um usuário
	 */
	@Test
	public void atualizarSenhaTest() {
		assertThat(repo.findByEmail("paulo@gmail.com").getSenha()).isEqualTo("fulano");
		user.setSenha("753951");
		repo.save(user);
		assertThat(repo.findByEmail("paulo@gmail.com").getSenha()).isEqualTo("753951");
	}

	/**
	 * Testa atualizar nome de um usuário
	 */

	@Test
	public void atualizarNomeTest() {
		assertThat(repo.findByEmail("paulo@gmail.com").getNome()).isEqualTo("Paulo");
		user.setNome("Edu");
		repo.save(user);
		assertThat(repo.findByEmail("paulo@gmail.com").getNome()).isEqualTo("Edu");
	}

}

