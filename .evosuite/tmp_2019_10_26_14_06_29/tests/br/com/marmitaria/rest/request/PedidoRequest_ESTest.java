/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 18:03:12 GMT 2019
 */

package br.com.marmitaria.rest.request;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.marmitaria.persistence.model.TipoPagamento;
import br.com.marmitaria.rest.request.PedidoRequest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class PedidoRequest_ESTest extends PedidoRequest_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      TipoPagamento tipoPagamento0 = TipoPagamento.CARTAO;
      pedidoRequest0.setTipoPagamento(tipoPagamento0);
      TipoPagamento tipoPagamento1 = pedidoRequest0.getTipoPagamento();
      assertSame(tipoPagamento1, tipoPagamento0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      pedidoRequest0.setObservacoes("N!vX0!%>#g");
      String string0 = pedidoRequest0.getObservacoes();
      assertEquals("N!vX0!%>#g", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      pedidoRequest0.setObservacoes("");
      String string0 = pedidoRequest0.getObservacoes();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      HashSet<Long> hashSet0 = new HashSet<Long>();
      pedidoRequest0.setIdProdutos(hashSet0);
      Set<Long> set0 = pedidoRequest0.getIdProdutos();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      LinkedHashSet<Long> linkedHashSet0 = new LinkedHashSet<Long>();
      Long long0 = new Long((-1157L));
      linkedHashSet0.add(long0);
      pedidoRequest0.setIdProdutos(linkedHashSet0);
      Set<Long> set0 = pedidoRequest0.getIdProdutos();
      assertTrue(set0.contains(long0));
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = new Long((-1465L));
      pedidoRequest0.setIdMarmita(long0);
      Long long1 = pedidoRequest0.getIdMarmita();
      assertEquals((-1465L), (long)long1);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = Long.valueOf(0L);
      pedidoRequest0.setIdMarmita(long0);
      Long long1 = pedidoRequest0.getIdMarmita();
      assertEquals(0L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = new Long(1598L);
      pedidoRequest0.setIdMarmita(long0);
      Long long1 = pedidoRequest0.getIdMarmita();
      assertEquals(1598L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = new Long(642L);
      pedidoRequest0.setIdMarmita(long0);
      Long long1 = pedidoRequest0.getIdMarmita();
      assertEquals(642L, (long)long1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      pedidoRequest0.setEmail("PWwu]W2P,9,=H");
      String string0 = pedidoRequest0.getEmail();
      assertEquals("PWwu]W2P,9,=H", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      String string0 = pedidoRequest0.getEmail();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      pedidoRequest0.setEmail("");
      String string0 = pedidoRequest0.getEmail();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      pedidoRequest0.getTipoPagamento();
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      String string0 = pedidoRequest0.getObservacoes();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = pedidoRequest0.getIdMarmita();
      pedidoRequest0.setIdMarmita(long0);
      assertNull(pedidoRequest0.getTipoPagamento());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Set<Long> set0 = pedidoRequest0.getIdProdutos();
      assertNull(set0);
  }
}
