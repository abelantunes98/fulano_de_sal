/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:21:12 GMT 2019
 */

package br.com.marmitaria.rest.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.persistence.model.TipoPagamento;
import br.com.marmitaria.rest.request.AdministradorRequest;
import br.com.marmitaria.rest.request.CardapioRequest;
import br.com.marmitaria.rest.request.CategoriaRequest;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.request.LoginRequest;
import br.com.marmitaria.rest.request.MarmitaRequest;
import br.com.marmitaria.rest.request.PedidoRequest;
import br.com.marmitaria.rest.request.ProdutoRequest;
import br.com.marmitaria.rest.request.RecuperacaoRequest;
import br.com.marmitaria.rest.request.UsuarioRequest;
import br.com.marmitaria.rest.util.Validation;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Validation_ESTest extends Validation_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      AdministradorRequest administradorRequest0 = new AdministradorRequest();
      administradorRequest0.setSenha("+@-.AA");
      administradorRequest0.setEmail("+@-.AA");
      administradorRequest0.setNome("+@-.AA");
      Validation.validaAdministrador(administradorRequest0);
      assertEquals("+@-.AA", administradorRequest0.getSenha());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.validaUsuario((UsuarioRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.validaLogin((LoginRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.validaCliente((ClienteRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.validaAdministrador((AdministradorRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((RecuperacaoRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((ProdutoRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((PedidoRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((MarmitaRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((CategoriaRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((CardapioRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((Produto) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((Marmita) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.valida((Categoria) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Long long0 = new Long((-1149L));
      boolean boolean0 = Validation.naoInformado(long0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      boolean boolean0 = Validation.naoInformado((Long) null);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.validaEmail("Tipo de pagamento n\u00E3o informado!");
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Email inv\u00E1lido!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Validation.validaEmail("+@-.AA");
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      // Undeclared exception!
      try { 
        Validation.validaEmail((String) null);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Email n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      boolean boolean0 = Validation.naoInformado("");
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      boolean boolean0 = Validation.naoInformado("+@-.AA");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      boolean boolean0 = Validation.naoInformado((String) null);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      AdministradorRequest administradorRequest0 = new AdministradorRequest();
      administradorRequest0.setNome("+@-.AA");
      administradorRequest0.setSenha("G$CLO");
      administradorRequest0.setEmail("+@-.AA");
      Validation.validaUsuario(administradorRequest0);
      assertEquals("+@-.AA", administradorRequest0.getNome());
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      AdministradorRequest administradorRequest0 = new AdministradorRequest();
      administradorRequest0.setNome("+@-.AA");
      administradorRequest0.setEmail("+@-.AA");
      // Undeclared exception!
      try { 
        Validation.validaUsuario(administradorRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Senha n\u00E3o informada!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      // Undeclared exception!
      try { 
        Validation.validaUsuario(usuarioRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Nome n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = new Long(1L);
      pedidoRequest0.setIdMarmita(long0);
      pedidoRequest0.setEmail("+@-.AA");
      HashSet<Long> hashSet0 = new HashSet<Long>();
      hashSet0.add(long0);
      pedidoRequest0.setIdProdutos(hashSet0);
      TipoPagamento tipoPagamento0 = TipoPagamento.CARTAO;
      pedidoRequest0.setTipoPagamento(tipoPagamento0);
      Validation.valida(pedidoRequest0);
      assertEquals(TipoPagamento.CARTAO, pedidoRequest0.getTipoPagamento());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = new Long(1L);
      pedidoRequest0.setIdMarmita(long0);
      pedidoRequest0.setEmail("+@-.AA");
      HashSet<Long> hashSet0 = new HashSet<Long>();
      hashSet0.add(long0);
      pedidoRequest0.setIdProdutos(hashSet0);
      // Undeclared exception!
      try { 
        Validation.valida(pedidoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Tipo de pagamento n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = new Long(1L);
      pedidoRequest0.setIdMarmita(long0);
      pedidoRequest0.setEmail("+@-.AA");
      HashSet<Long> hashSet0 = new HashSet<Long>();
      pedidoRequest0.setIdProdutos(hashSet0);
      // Undeclared exception!
      try { 
        Validation.valida(pedidoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Pedido sem produtos!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      pedidoRequest0.setEmail("+@-.AA");
      // Undeclared exception!
      try { 
        Validation.valida(pedidoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Marmita n\u00E3o selecionada!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      PedidoRequest pedidoRequest0 = new PedidoRequest();
      Long long0 = new Long(1L);
      pedidoRequest0.setIdMarmita(long0);
      pedidoRequest0.setEmail("+@-.AA");
      // Undeclared exception!
      try { 
        Validation.valida(pedidoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Pedido sem produtos!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      CardapioRequest cardapioRequest0 = new CardapioRequest();
      LinkedHashSet<Long> linkedHashSet0 = new LinkedHashSet<Long>();
      linkedHashSet0.add((Long) null);
      cardapioRequest0.setIdProdutos(linkedHashSet0);
      Validation.valida(cardapioRequest0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      CardapioRequest cardapioRequest0 = new CardapioRequest();
      LinkedHashSet<Long> linkedHashSet0 = new LinkedHashSet<Long>();
      cardapioRequest0.setIdProdutos(linkedHashSet0);
      // Undeclared exception!
      try { 
        Validation.valida(cardapioRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Cardapio sem produtos!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      CardapioRequest cardapioRequest0 = new CardapioRequest();
      // Undeclared exception!
      try { 
        Validation.valida(cardapioRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Cardapio sem produtos!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Produto produto0 = new Produto();
      Long long0 = new Long(1L);
      produto0.setIdProduto(long0);
      produto0.setNome("Shoez");
      Validation.valida(produto0);
      assertEquals(1L, (long)produto0.getIdProduto());
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Produto produto0 = new Produto();
      Long long0 = new Long(1L);
      produto0.setIdProduto(long0);
      // Undeclared exception!
      try { 
        Validation.valida(produto0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Nome n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Categoria categoria0 = new Categoria();
      Long long0 = new Long(0L);
      categoria0.setId(long0);
      categoria0.setDescricao("%s-%s");
      Validation.valida(categoria0);
      assertEquals(0L, (long)categoria0.getId());
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Categoria categoria0 = new Categoria("p;,&{G\\e|\"Qf#");
      // Undeclared exception!
      try { 
        Validation.valida(categoria0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Id n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Categoria categoria0 = new Categoria();
      Long long0 = new Long(0L);
      categoria0.setId(long0);
      // Undeclared exception!
      try { 
        Validation.valida(categoria0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Descri\u00E7\u00E3o n\u00E3o informada!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Marmita marmita0 = new Marmita();
      // Undeclared exception!
      try { 
        Validation.valida(marmita0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Id n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      Marmita marmita0 = new Marmita();
      Long long0 = new Long(449L);
      marmita0.setIdMarmita(long0);
      // Undeclared exception!
      try { 
        Validation.valida(marmita0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Valor n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      ProdutoRequest produtoRequest0 = new ProdutoRequest();
      Long long0 = new Long(0L);
      produtoRequest0.setIdCategoria(long0);
      produtoRequest0.setNome("Y_?Jy");
      Validation.valida(produtoRequest0);
      assertNull(produtoRequest0.getIdProduto());
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      ProdutoRequest produtoRequest0 = new ProdutoRequest();
      // Undeclared exception!
      try { 
        Validation.valida(produtoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Categoria n\u00E3o informada!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      CategoriaRequest categoriaRequest0 = new CategoriaRequest();
      // Undeclared exception!
      try { 
        Validation.valida(categoriaRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Descri\u00E7\u00E3o n\u00E3o informada!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      CategoriaRequest categoriaRequest0 = new CategoriaRequest();
      categoriaRequest0.setDescricao("H");
      Validation.valida(categoriaRequest0);
      assertEquals("H", categoriaRequest0.getDescricao());
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      RecuperacaoRequest recuperacaoRequest0 = new RecuperacaoRequest();
      recuperacaoRequest0.setSenha("+@-.AA");
      recuperacaoRequest0.setEmail("+@-.AA");
      Validation.valida(recuperacaoRequest0);
      assertEquals("+@-.AA", recuperacaoRequest0.getEmail());
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      RecuperacaoRequest recuperacaoRequest0 = new RecuperacaoRequest();
      // Undeclared exception!
      try { 
        Validation.valida(recuperacaoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Email n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      RecuperacaoRequest recuperacaoRequest0 = new RecuperacaoRequest();
      recuperacaoRequest0.setEmail("+@-BA");
      // Undeclared exception!
      try { 
        Validation.valida(recuperacaoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Senha n\u00E3o informada!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      Produto produto0 = new Produto();
      // Undeclared exception!
      try { 
        Validation.valida(produto0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Id n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      ProdutoRequest produtoRequest0 = new ProdutoRequest();
      Long long0 = new Long(0L);
      produtoRequest0.setIdCategoria(long0);
      // Undeclared exception!
      try { 
        Validation.valida(produtoRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Nome n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      MarmitaRequest marmitaRequest0 = new MarmitaRequest();
      marmitaRequest0.setValor((-923.91437F));
      marmitaRequest0.setTipo("p;,&{G\\e|\"Qf#");
      Validation.valida(marmitaRequest0);
      assertEquals(0, marmitaRequest0.getCarnes());
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      MarmitaRequest marmitaRequest0 = new MarmitaRequest();
      // Undeclared exception!
      try { 
        Validation.valida(marmitaRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Valor n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      MarmitaRequest marmitaRequest0 = new MarmitaRequest();
      marmitaRequest0.setValor((-923.91437F));
      // Undeclared exception!
      try { 
        Validation.valida(marmitaRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Tipo n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      LoginRequest loginRequest0 = new LoginRequest();
      loginRequest0.setEmail("Y_?Jy");
      // Undeclared exception!
      try { 
        Validation.validaLogin(loginRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Email inv\u00E1lido!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      ClienteRequest clienteRequest0 = new ClienteRequest();
      clienteRequest0.setNome("");
      // Undeclared exception!
      try { 
        Validation.validaCliente(clienteRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Nome n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      ClienteRequest clienteRequest0 = new ClienteRequest();
      clienteRequest0.setNome("+@-.AA");
      clienteRequest0.setSenha("+@-.AA");
      clienteRequest0.setEmail("+@-.AA");
      // Undeclared exception!
      try { 
        Validation.validaCliente(clienteRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Endere\u00E7o n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      ClienteRequest clienteRequest0 = new ClienteRequest();
      clienteRequest0.setEndereco("+@-.AA");
      clienteRequest0.setNome("+@-.AA");
      clienteRequest0.setSenha("+@-.AA");
      clienteRequest0.setEmail("+@-.AA");
      Validation.validaCliente(clienteRequest0);
      assertEquals("+@-.AA", clienteRequest0.getEndereco());
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      LoginRequest loginRequest0 = new LoginRequest();
      loginRequest0.setEmail("+@-.sy");
      // Undeclared exception!
      try { 
        Validation.validaLogin(loginRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Senha n\u00E3o informada!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      LoginRequest loginRequest0 = new LoginRequest();
      loginRequest0.setEmail("+@70.AA");
      loginRequest0.setSenha("+@70.AA");
      Validation.validaLogin(loginRequest0);
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      AdministradorRequest administradorRequest0 = new AdministradorRequest();
      // Undeclared exception!
      try { 
        Validation.validaAdministrador(administradorRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Nome n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }
}