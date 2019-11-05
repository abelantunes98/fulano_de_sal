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

import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.TipoMarmita;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class MarmitaDAOTest {

	@Autowired
	private MarmitaDAO repositorioMarmitas;

	private Marmita marmita1;
	
	private Marmita marmita2;

	/**
	 * Inicia variáveis para os testes
	 */
	@Before
	public void init() {
		
		marmita1 = new Marmita(15, TipoMarmita.TRADICIONAL, "3 carnes e 7 acompanhamentos", 3);
		marmita2 = new Marmita(10, TipoMarmita.DIVISORIA, "3 carnes e 7 acompanhamentos", 2);
		repositorioMarmitas.save(marmita2);
	}

	/**
	 * Testa criar marmita com sucesso
	 */
	@Test
	public void criarMarmitaTest() {
		repositorioMarmitas.save(marmita1);
		assertThat(repositorioMarmitas.getOne(marmita1.getIdMarmita()).getDescricao()).isEqualTo("3 carnes e 7 acompanhamentos");
		assertThat(repositorioMarmitas.count()).isEqualTo(2);
	}

	/**
	 * Testa criar marmita com descrição nula
	 */

	@Test(expected = ConstraintViolationException.class)
	public void criarMarmitaDescricaoNulaTest() {
		marmita1.setDescricao(null);
		repositorioMarmitas.save(marmita1);
	}

	/**
	 * Testa criar marmita com valor negativo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarMarmitaValorNegativoTest() {
		marmita1.setValor(-1);
		repositorioMarmitas.save(marmita1);

	}
	
	/**
	 * Testa criar marmita com valor zero
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarMarmitaValorZeroTest() {
		marmita1.setValor(0);
		repositorioMarmitas.save(marmita1);

	}
	

	/**
	 * Testa criar marmita com tipo nulo
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarMarmitaTipoNuloTest() {
		marmita1.setTipoMarmita(null);
		repositorioMarmitas.save(marmita1);

	}

	/**
	 * Testa criar marmita com quantidade de carnes negativa
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarMarmitaQuantidadeDeCarnesNegativaTest() {
		marmita1.setCarnes(-1);
		repositorioMarmitas.save(marmita1);
	}
	
	/**
	 * Testa criar marmita com quantidade de carnes zero
	 */
	@Test(expected = ConstraintViolationException.class)
	public void criarMarmitaQuantidadeDeCarnesZeroTest() {
		marmita1.setCarnes(0);
		repositorioMarmitas.save(marmita1);
	}

	/**
	 * Testa atualizar a quantidade de carnes de uma marmita
	 */
	@Test
	public void atualizarQuantidadeDeCarnesTest() {
		assertThat(repositorioMarmitas.getOne(marmita2.getIdMarmita()).getCarnes()).isEqualTo(2);
		marmita2.setCarnes(1);
		repositorioMarmitas.save(marmita2);
		assertThat(repositorioMarmitas.getOne(marmita2.getIdMarmita()).getCarnes()).isEqualTo(1);

	}

	/**
	 * Testa atualizar descrição de uma marmita
	 */
	@Test
	public void atualizarDescricaoTest() {
		assertThat(repositorioMarmitas.getOne(marmita2.getIdMarmita()).getDescricao()).isEqualTo("3 carnes e 7 acompanhamentos");
		marmita2.setDescricao("2 carnes e 8 acompanhamentos");
		repositorioMarmitas.save(marmita2);
		assertThat(repositorioMarmitas.getOne(marmita2.getIdMarmita()).getDescricao()).isEqualTo("2 carnes e 8 acompanhamentos");
	}

	/**
	 * Testa atualizar o valor de uma marmita
	 */
	@Test
	public void atualizarValorTest() {
		assertThat(repositorioMarmitas.getOne(marmita2.getIdMarmita()).getValor()).isEqualTo(10);
		marmita2.setValor(7);
		repositorioMarmitas.save(marmita2);
		assertThat(repositorioMarmitas.getOne(marmita2.getIdMarmita()).getValor()).isEqualTo(7);
	}

}
