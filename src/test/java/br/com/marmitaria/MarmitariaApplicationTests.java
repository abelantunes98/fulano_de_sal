package br.com.marmitaria;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marmitaria.persistence.dao.ProdutoDAO;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Usuario;
import br.com.marmitaria.persistence.service.ProdutoService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MarmitariaApplicationTests {
	
	
	@Test
	public void contextLoads() {
	}

}
