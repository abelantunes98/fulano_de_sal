package br.com.marmitaria.persistence.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marmitaria.persistence.model.Recuperacao;
import br.com.marmitaria.persistence.model.TipoUsuario;
import br.com.marmitaria.persistence.model.Usuario;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class RecuperacaoDAOTest {
	
	@Autowired
	private RecuperacaoDAO repositorioRecuperacao;
	
	@Autowired
	private UsuarioDAO repositorioUsuarios;
	
	private Recuperacao recuperacao;
	
	private Usuario usuario;
	
	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		usuario = new Usuario();
		usuario.setNome("Paulo");
		usuario.setEmail("paulo@gmail.com");
		usuario.setSenha("fulano");
		usuario.setTipo(TipoUsuario.CLIENTE);
		usuario.setCadastroPendente(true);
		repositorioUsuarios.save(usuario);
		recuperacao = new Recuperacao();
		recuperacao.setUsuario(usuario);
		recuperacao.setDataCriacao(new Date());
		recuperacao.setCodigo("cdcdc");
		
	}
	/**
	 * Testa criar uma instância de recuperação com sucesso
	 */
	@Test
	public void criarRecuperacaoTest() {
		repositorioRecuperacao.save(recuperacao);
		assertThat(repositorioRecuperacao.count()).isEqualTo(1);
		assertThat(repositorioRecuperacao.getOne(1L)).isEqualTo(recuperacao);
		
	}
	/**
	 * Testa criar uma instância de recuperação com cliente nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarRecuperacaoClienteNuloTest() {
		recuperacao.setUsuario(null);
		repositorioRecuperacao.save(recuperacao);
	}
	/**
	 * Testa criar uma instância de recuperação com data de nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarRecuperacaoDataNulaTest() {
		recuperacao.setDataCriacao(null);
		repositorioRecuperacao.save(recuperacao);
	}
	/**
	 * Testa criar uma instância de recuperação com código nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarRecuperacaoCodigoNuloTest() {
		recuperacao.setCodigo(null);
		repositorioRecuperacao.save(recuperacao);
	}
	/**
	 * Testa criar uma instância de recuperação com código vazio
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarRecuperacaoCodigoVazioTest() {
		recuperacao.setCodigo("");
		repositorioRecuperacao.save(recuperacao);
	}
}
