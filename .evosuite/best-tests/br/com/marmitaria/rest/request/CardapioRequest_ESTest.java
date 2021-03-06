/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:57:42 GMT 2019
 */

package br.com.marmitaria.rest.request;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.marmitaria.rest.request.CardapioRequest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CardapioRequest_ESTest extends CardapioRequest_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      CardapioRequest cardapioRequest0 = new CardapioRequest();
      LinkedHashSet<Long> linkedHashSet0 = new LinkedHashSet<Long>();
      Long long0 = new Long(1199L);
      linkedHashSet0.add(long0);
      cardapioRequest0.setIdProdutos(linkedHashSet0);
      Set<Long> set0 = cardapioRequest0.getIdProdutos();
      assertTrue(set0.contains(1199L));
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      CardapioRequest cardapioRequest0 = new CardapioRequest();
      Set<Long> set0 = cardapioRequest0.getIdProdutos();
      assertNull(set0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      CardapioRequest cardapioRequest0 = new CardapioRequest();
      HashSet<Long> hashSet0 = new HashSet<Long>();
      cardapioRequest0.setIdProdutos(hashSet0);
      Set<Long> set0 = cardapioRequest0.getIdProdutos();
      assertTrue(set0.isEmpty());
  }
}
