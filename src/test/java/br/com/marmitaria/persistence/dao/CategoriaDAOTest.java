package br.com.marmitaria.persistence.dao;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marmitaria.persistence.model.Categoria;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
public class CategoriaDAOTest {

	@Autowired
	private CategoriaDAO repositorioCategorias;

	/**
	 * Testa criar uma categoria corretamente
	 */
	@Test
	public void criarCategoriaTest() {
		Categoria categoria = new Categoria("Feijões");
		repositorioCategorias.save(categoria);
		assertThat(repositorioCategorias.count()).isEqualTo(1);
		assertThat(repositorioCategorias.findByDescricao("Feijões")).isNotNull();
	}

	/**
	 * Testa criar uma categoria com descrição nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarCategoriaDescricaoNulaTest() {

		Categoria categoria = new Categoria(null);
		repositorioCategorias.save(categoria);

	}
	/**
	 * Testa criar uma categoria com descrição vazia
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarCategoriaDescricaoVaziaTest() {
		Categoria categoria = new Categoria("");
		repositorioCategorias.save(categoria);

	}
	/**
	 * Testa atualizar categoria
	 */
	@Test
	public void atualizarCategoriaTest() {
		Categoria categoria = new Categoria("Feijões");
		repositorioCategorias.save(categoria);
		categoria.setDescricao("Massas");
		repositorioCategorias.save(categoria);
		assertThat(repositorioCategorias.getOne(categoria.getId()).getDescricao()).isEqualTo("Massas");

	}

	/**
	 * Testa deletar categoria
	 */
	@Test
	public void deletarCategoriaTest() {
		Categoria categoria = new Categoria("Feijões");
		repositorioCategorias.save(categoria);
		assertThat(repositorioCategorias.count()).isEqualTo(1);
		repositorioCategorias.delete(categoria);
		assertThat(repositorioCategorias.count()).isEqualTo(0);

	}
}
