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

import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;


@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
public class ProdutoDAOTest {

	private Produto produto;

	private Categoria categoria;
	@Autowired
	private ProdutoDAO repo;

	@Autowired
	private CategoriaDAO categ;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		produto = new Produto();
		categoria = new Categoria("Feijões");
		categ.save(categoria);
		produto.setNome("Feijão Branco");
		produto.setCategoria(categoria);
	}

	/**
	 * Testa criar um produto corretamene
	 */
	@Test
	public void criarProdutoTest() {
		repo.save(produto);
		assertThat(repo.count()).isEqualTo(1);
		assertThat(repo.findByNome("Feijão Branco")).isNotNull();
	}

	/**
	 * Testa criar um produto com categoria nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarProdutoCategoriaNulaTest() {
		produto.setCategoria(null);
		repo.save(produto);

	}

	/**
	 * Testa criar um produto com nome vazio
	 */

	@Test(expected = ConstraintViolationException.class)
	public void criarProdutoNomeVazioTest() {
		produto.setNome("");
		repo.save(produto);

	}
	
	/**
	 * Testa criar um produto com nome nulo
	 */

	@Test(expected = ConstraintViolationException.class)
	public void criarProdutoNomeNuloTest() {
		produto.setNome(null);
		repo.save(produto);

	}

	/**
	 * Testa atualizar o nome de um produto
	 */
	@Test
	public void atualizarNomeProdutoTest() {
		repo.save(produto);
		assertThat(repo.getOne(produto.getIdProduto()).getNome()).isEqualTo("Feijão Branco");
		produto.setNome("Feijão Preto");
		repo.save(produto);
		assertThat(repo.getOne(produto.getIdProduto()).getNome()).isEqualTo("Feijão Preto");

	}

	/**
	 * Testa atualizar a categoria de um produto
	 */
	@Test
	public void atualizarCategoriaProdutoTest() {
		repo.save(produto);
		assertThat(repo.count()).isEqualTo(1);
		repo.delete(produto);
		assertThat(repo.count()).isEqualTo(0);
	}

	/**
	 * Testa deletar um produto
	 */
	@Test
	public void deletarProdutoTest() {
		repo.save(produto);
		assertThat(repo.count()).isEqualTo(1);
		repo.delete(produto);
		assertThat(repo.count()).isEqualTo(0);

	}

}
