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
	private PedidoDAO repositorioPedidos;
	
	@Autowired
	private CategoriaDAO repositorioCategorias;
	
	@Autowired
	private ClienteDAO repositorioClientes;

	@Autowired
	private ProdutoDAO repositorioProdutos;
	
	@Autowired
	private MarmitaDAO repositorioMarmitas;

	private Categoria categoria;
	
	private Pedido pedido;

	private List<Produto> listaProdutos;
	
	private Marmita marmita;
	
	private Cliente cliente;
	
	private ClienteRequest clienteRequest;
	
	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {

		Produto produto1 = new Produto();
		Produto produto2 = new Produto();
		categoria = new Categoria("Feijões");
		repositorioCategorias.save(categoria);
		produto1.setNome("Feijão Branco");
		produto1.setCategoria(categoria);
		produto2.setNome("Feijão Preto");
		produto2.setCategoria(categoria);
		listaProdutos = new ArrayList<Produto>();
		repositorioProdutos.save(produto1);
		repositorioProdutos.save(produto2);
		listaProdutos.add(produto1);
		listaProdutos.add(produto2);
		clienteRequest = new ClienteRequest();
		clienteRequest.setNome("Paulo");
		clienteRequest.setTelefone("98555555");
		clienteRequest.setEmail("paulo@gmail.com");
		clienteRequest.setSenha("fulano");
		clienteRequest.setEndereco("Rua da esquina");
		cliente = new Cliente(clienteRequest);
		repositorioClientes.save(cliente);
		marmita = new Marmita(15, TipoMarmita.TRADICIONAL, "3 carnes e 7 acompanhamentos", 3);
		repositorioMarmitas.save(marmita);

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
		pedido.setProdutos(listaProdutos);
		pedido.setTipoPagamento(TipoPagamento.DINHEIRO);
	
	}
	
	/**
	 * Testa criar um pedido corretamene
	 */
	@Test
	public void criarPedidoTest() {
		repositorioPedidos.save(pedido);
		assertThat(repositorioPedidos.count()).isEqualTo(1);
		assertThat(repositorioPedidos.getOne(1L)).isEqualTo(pedido);

	}
	
	/**
	 * Testa criar um pedido com cliente nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoClienteNuloTest() {
		pedido.setCliente(null);
		repositorioPedidos.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com data nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoDataNulaTest() {
		pedido.setData(null);
		repositorioPedidos.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com observações nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoObservacoesNulaTest() {
		pedido.setObsvacoes(null);
		repositorioPedidos.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com marmita nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoMarmitaNulaTest() {
		pedido.setMarmita(null);
		repositorioPedidos.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com lista de produtos nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoListaProdutosNulaTest() {
		pedido.setProdutos(null);
		repositorioPedidos.save(pedido);

	}
	
	/**
	 * Testa criar um pedido com confirmação nula
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarPedidoConfirmacaoNulaTest() {
		pedido.setConfirmado(null);
		repositorioPedidos.save(pedido);

	}

}
