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
	private UsuarioDAO repositorioUsuarios;

	private Usuario usuario;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		usuario = new Usuario();
		usuario.setTipo(TipoUsuario.CLIENTE);
		usuario.setNome("Paulo");
		usuario.setCadastroPendente(true);
		usuario.setEmail("paulo@gmail.com");
		usuario.setSenha("fulano");
		repositorioUsuarios.save(usuario);

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
		repositorioUsuarios.save(u);
		assertThat(repositorioUsuarios.count()).isEqualTo(2);
		assertThat(repositorioUsuarios.findByEmail("edu@gmail.com").getNome()).isEqualTo("Eduardo");
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
		repositorioUsuarios.save(u);
		assertThat(repositorioUsuarios.count()).isEqualTo(2);
		assertThat(repositorioUsuarios.findByEmail("edu@gmail.com").getNome()).isEqualTo("Eduardo");
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
		repositorioUsuarios.save(u);
		assertThat(repositorioUsuarios.count()).isEqualTo(1);
		assertThat(repositorioUsuarios.findByEmail("edu@gmail.com").getNome()).isEqualTo("Eduardo");
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
		repositorioUsuarios.save(u);

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
		repositorioUsuarios.save(u);

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
		repositorioUsuarios.save(u);

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
		repositorioUsuarios.save(u);

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
		repositorioUsuarios.save(u);

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
		repositorioUsuarios.save(u);
	}

	/**
	 * Testa atualizar email de um usuário
	 */
	@Test
	public void atualizarEmailTest() {
		usuario.setEmail("edu@gmail.com");
		repositorioUsuarios.save(usuario);
		assertThat(repositorioUsuarios.findByEmail("paulo@gmail.com")).isNotNull();
		assertThat(repositorioUsuarios.findByEmail("edu@gmail.com")).isNull();
	}

	/**
	 * Testa atualizar senha de um usuário
	 */
	@Test
	public void atualizarSenhaTest() {
		assertThat(repositorioUsuarios.findByEmail("paulo@gmail.com").getSenha()).isEqualTo("fulano");
		usuario.setSenha("753951");
		repositorioUsuarios.save(usuario);
		assertThat(repositorioUsuarios.findByEmail("paulo@gmail.com").getSenha()).isEqualTo("753951");
	}

	/**
	 * Testa atualizar nome de um usuário
	 */

	@Test
	public void atualizarNomeTest() {
		assertThat(repositorioUsuarios.findByEmail("paulo@gmail.com").getNome()).isEqualTo("Paulo");
		usuario.setNome("Edu");
		repositorioUsuarios.save(usuario);
		assertThat(repositorioUsuarios.findByEmail("paulo@gmail.com").getNome()).isEqualTo("Edu");
	}

}

