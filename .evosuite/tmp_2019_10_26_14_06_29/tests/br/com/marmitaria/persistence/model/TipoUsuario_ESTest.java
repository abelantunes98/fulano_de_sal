/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 18:01:53 GMT 2019
 */

package br.com.marmitaria.persistence.model;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.marmitaria.persistence.model.TipoUsuario;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class TipoUsuario_ESTest extends TipoUsuario_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      TipoUsuario[] tipoUsuarioArray0 = TipoUsuario.values();
      assertEquals(2, tipoUsuarioArray0.length);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      TipoUsuario tipoUsuario0 = TipoUsuario.valueOf("ADMINISTRADOR");
      assertEquals("ADMINISTRADOR", tipoUsuario0.getValor());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      TipoUsuario tipoUsuario0 = TipoUsuario.ADMINISTRADOR;
      String string0 = tipoUsuario0.getValor();
      assertEquals("ADMINISTRADOR", string0);
  }
}
