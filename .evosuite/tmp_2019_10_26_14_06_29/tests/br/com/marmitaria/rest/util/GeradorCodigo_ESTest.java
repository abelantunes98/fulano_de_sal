/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:38:53 GMT 2019
 */

package br.com.marmitaria.rest.util;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.marmitaria.rest.util.GeradorCodigo;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class GeradorCodigo_ESTest extends GeradorCodigo_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      String string0 = GeradorCodigo.gerarCodigoRecuperacaoSenha();
      //  // Unstable assertion: assertEquals("1259x", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      GeradorCodigo geradorCodigo0 = new GeradorCodigo();
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      GeradorCodigo.main((String[]) null);
  }
}
