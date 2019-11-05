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
	private ProdutoDAO repositorioProdutos;

	@Autowired
	private CategoriaDAO repositorioCategorias;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		produto = new Produto();
		categoria = new Categoria("Feijões");
		repositorioCategorias.save(categoria);
		produto.setNome("Feijão Branco");
		produto.setCategoria(categoria);
	}

	/**
	 * Testa criar um produto corretamene
	 */
	@Test
	public void criarProdutoTest() {
		repositorioProdutos.save(produto);
		assertThat(repositorioProdutos.count()).isEqualTo(1);
		assertThat(repositorioProdutos.findByNome("Feijão Branco")).isNotNull();
	}
	
//	/**
//	 * Testa criar um produto com um nome já existente
//	 */
//	@Test(expected = DataIntegrityViolationException.class)
//	public void criarProdutoNomeExisteTest() {
//		repo.save(produto);
//		Produto produto1 = new Produto();
//		produto1.setCategoria(categoria);
//		produto1.setNome("Feijão Branco");
//		repo.save(produto1);
//		
//	}

	/**
	 * Testa criar um produto com categoria nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarProdutoCategoriaNulaTest() {
		produto.setCategoria(null);
		repositorioProdutos.save(produto);

	}

	/**
	 * Testa criar um produto com nome vazio
	 */

	@Test(expected = ConstraintViolationException.class)
	public void criarProdutoNomeVazioTest() {
		produto.setNome("");
		repositorioProdutos.save(produto);

	}
	
	/**
	 * Testa criar um produto com nome nulo
	 */

	@Test(expected = ConstraintViolationException.class)
	public void criarProdutoNomeNuloTest() {
		produto.setNome(null);
		repositorioProdutos.save(produto);

	}

	/**
	 * Testa atualizar o nome de um produto
	 */
	@Test
	public void atualizarNomeProdutoTest() {
		repositorioProdutos.save(produto);
		assertThat(repositorioProdutos.getOne(produto.getIdProduto()).getNome()).isEqualTo("Feijão Branco");
		produto.setNome("Feijão Preto");
		repositorioProdutos.save(produto);
		assertThat(repositorioProdutos.getOne(produto.getIdProduto()).getNome()).isEqualTo("Feijão Preto");

	}

	/**
	 * Testa atualizar a categoria de um produto
	 */
	@Test
	public void atualizarCategoriaProdutoTest() {
		repositorioProdutos.save(produto);
		assertThat(repositorioProdutos.count()).isEqualTo(1);
		repositorioProdutos.delete(produto);
		assertThat(repositorioProdutos.count()).isEqualTo(0);
	}

	/**
	 * Testa deletar um produto
	 */
	@Test
	public void deletarProdutoTest() {
		repositorioProdutos.save(produto);
		assertThat(repositorioProdutos.count()).isEqualTo(1);
		repositorioProdutos.delete(produto);
		assertThat(repositorioProdutos.count()).isEqualTo(0);

	}

}
