package br.com.marmitaria.persistence.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marmitaria.persistence.model.Cardapio;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class CardapioDAOTest {

	@Autowired
	private CardapioDAO repo;

	@Autowired
	private CategoriaDAO categ;

	@Autowired
	private ProdutoDAO prod;

	private Categoria categoria;

	private List<Produto> lista;
	
	private Cardapio cardapio;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {

		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		categoria = new Categoria("Feijões");
		categ.save(categoria);
		produto1.setNome("Feijão Branco");
		produto1.setCategoria(categoria);
		produto2.setNome("Feijão Preto");
		produto2.setCategoria(categoria);
		lista = new ArrayList<Produto>();
		prod.save(produto1);
		prod.save(produto2);
		lista.add(produto1);
		lista.add(produto2);

	}

	/**
	 * Testa criar um cardápio corretamene
	 */
	@Test
	public void criarCardapioTest() {
		cardapio = new Cardapio();
		cardapio.setProdutos(lista);
		cardapio.setData(new Date());
		repo.save(cardapio);
		assertThat(repo.count()).isEqualTo(1);
		assertThat(repo.getOne(1L)).isEqualTo(cardapio);

	}

	/**
	 * Testa criar um cardápio com lista de produtos nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarCardapioListaProdutosNulaTest() {
		cardapio = new Cardapio();
		cardapio.setProdutos(null);
		cardapio.setData(new Date());
		repo.save(cardapio);

	}

	/**
	 * Testa criar um cardápio com data nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarCardapioDataNulaTest() {
		cardapio = new Cardapio();
		cardapio.setProdutos(lista);
		cardapio.setData(null);
		repo.save(cardapio);

	}

}
