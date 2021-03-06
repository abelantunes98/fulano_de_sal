/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:40:27 GMT 2019
 */

package br.com.marmitaria.rest.reponse;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.marmitaria.persistence.model.Cardapio;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.rest.reponse.CardapioRespose;
import br.com.marmitaria.rest.reponse.CategoriaResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CardapioRespose_ESTest extends CardapioRespose_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate(0, 0, 0, (-1096), (-1096), 0);
      cardapio0.setData(mockDate0);
      Vector<Produto> vector0 = new Vector<Produto>();
      Produto produto0 = new Produto();
      Categoria categoria0 = new Categoria();
      produto0.setCategoria(categoria0);
      vector0.add(produto0);
      cardapio0.setProdutos(vector0);
      CardapioRespose cardapioRespose0 = new CardapioRespose(cardapio0);
      assertEquals("14/11/1899 10:44:00", cardapioRespose0.getData());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate();
      LinkedList<Produto> linkedList0 = new LinkedList<Produto>();
      cardapio0.setData(mockDate0);
      cardapio0.setProdutos(linkedList0);
      CardapioRespose cardapioRespose0 = new CardapioRespose(cardapio0);
      cardapioRespose0.setData((String) null);
      String string0 = cardapioRespose0.getData();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate(12, 12, 12);
      ArrayList<Produto> arrayList0 = new ArrayList<Produto>();
      cardapio0.setProdutos(arrayList0);
      cardapio0.setData(mockDate0);
      CardapioRespose cardapioRespose0 = new CardapioRespose(cardapio0);
      cardapioRespose0.setData("");
      String string0 = cardapioRespose0.getData();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate();
      cardapio0.setData(mockDate0);
      ArrayList<Produto> arrayList0 = new ArrayList<Produto>();
      cardapio0.setProdutos(arrayList0);
      CardapioRespose cardapioRespose0 = new CardapioRespose(cardapio0);
      cardapioRespose0.setCategorias((List<CategoriaResponse>) null);
      List<CategoriaResponse> list0 = cardapioRespose0.getCategorias();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate();
      cardapio0.setData(mockDate0);
      ArrayList<Produto> arrayList0 = new ArrayList<Produto>();
      cardapio0.setProdutos(arrayList0);
      CardapioRespose cardapioRespose0 = new CardapioRespose(cardapio0);
      Stack<CategoriaResponse> stack0 = new Stack<CategoriaResponse>();
      stack0.setSize(1021);
      cardapioRespose0.setCategorias(stack0);
      List<CategoriaResponse> list0 = cardapioRespose0.getCategorias();
      assertFalse(list0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate(0, 0, 0, (-1096), (-1096), 0);
      cardapio0.setData(mockDate0);
      Vector<Produto> vector0 = new Vector<Produto>();
      Produto produto0 = new Produto();
      vector0.add(produto0);
      vector0.add(produto0);
      cardapio0.setProdutos(vector0);
      CardapioRespose cardapioRespose0 = null;
      try {
        cardapioRespose0 = new CardapioRespose(cardapio0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.reponse.CategoriaResponse", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate();
      LinkedList<Produto> linkedList0 = new LinkedList<Produto>();
      cardapio0.setData(mockDate0);
      cardapio0.setProdutos(linkedList0);
      CardapioRespose cardapioRespose0 = new CardapioRespose(cardapio0);
      String string0 = cardapioRespose0.getData();
      assertEquals("14/02/2014 17:21:21", string0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      Cardapio cardapio0 = new Cardapio();
      MockDate mockDate0 = new MockDate(0, 0, 0, (-1096), (-1096), 0);
      cardapio0.setData(mockDate0);
      Vector<Produto> vector0 = new Vector<Produto>();
      cardapio0.setProdutos(vector0);
      CardapioRespose cardapioRespose0 = new CardapioRespose(cardapio0);
      List<CategoriaResponse> list0 = cardapioRespose0.getCategorias();
      assertEquals(0, list0.size());
  }
}
