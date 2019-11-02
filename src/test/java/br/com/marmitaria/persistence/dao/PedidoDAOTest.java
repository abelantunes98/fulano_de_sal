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
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.Pedido;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.persistence.model.TipoMarmita;
import br.com.marmitaria.persistence.model.TipoPagamento;
import br.com.marmitaria.rest.request.ClienteRequest;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations="classpath:test.properties")
public class PedidoDAOTest {
	
	@Autowired
	private PedidoDAO repo;
	
	@Autowired
	private CategoriaDAO categ;
	
	@Autowired
	private ClienteDAO clien;

	@Autowired
	private ProdutoDAO prod;
	
	@Autowired
	private MarmitaDAO marmit;

	private Categoria categoria;
	
	private Pedido pedido;

	private List<Produto> lista;
	
	private Marmita marmita;
	
	private Cliente cliente;
	
	private ClienteRequest user;
	
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
		user = new ClienteRequest();
		user.setNome("Paulo");
		user.setTelefone("98555555");
		user.setEmail("paulo@gmail.com");
		user.setSenha("fulano");
		user.setEndereco("Rua da esquina");
		cliente = new Cliente(user);
		clien.save(cliente);
		marmita = new Marmita(15, TipoMarmita.TRADICIONAL, "3 carnes e 7 acompanhamentos", 3);
		marmit.save(marmita);

	}
	
	/**
	 * Inicia um pedido
	 */
	@Before
	public void iniciaPedido () {
		pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setConfirmado(false);
		pedido.setData(new Date());
		pedido.setMarmita(marmita);
		pedido.setObsvacoes("TALHERES");
		pedido.setProdutos(lista);
		pedido.setTipoPagamento(TipoPagamento.DINHEIRO);
	
	}
	
	/**
	 * Testa criar um pedido corretamene
	 */
	@Test
	public void criarPedidoTest() {
		repo.save(pedido);
		assertThat(repo.count()).isEqualTo(1);
		assertThat(repo.getOne(1L)).isEqualTo(pedido);

	}
	
	/**
	 * Testa criar um pedido com cliente nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoClienteNuloTest() {
		pedido.setCliente(null);
		repo.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com data nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoDataNulaTest() {
		pedido.setData(null);
		repo.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com observações nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoObservacoesNulaTest() {
		pedido.setObsvacoes(null);
		repo.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com marmita nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoMarmitaNulaTest() {
		pedido.setMarmita(null);
		repo.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com lista de produtos nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoListaProdutosNulaTest() {
		pedido.setProdutos(null);
		repo.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com confirmação nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoConfirmacaoNulaTest() {
		pedido.setConfirmado(null);
		repo.save(pedido);

	}

}
