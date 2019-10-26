/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:57:51 GMT 2019
 */

package br.com.marmitaria.rest.request;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.marmitaria.rest.request.UsuarioRequest;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UsuarioRequest_ESTest extends UsuarioRequest_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      usuarioRequest0.setSenha("(vSO^<'h3to");
      String string0 = usuarioRequest0.getSenha();
      assertEquals("(vSO^<'h3to", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      usuarioRequest0.setNome("WA,\"KI!mYl");
      String string0 = usuarioRequest0.getNome();
      assertEquals("WA,\"KI!mYl", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      usuarioRequest0.setEmail("\"<4p$z");
      String string0 = usuarioRequest0.getEmail();
      assertEquals("\"<4p$z", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      usuarioRequest0.setEmail("");
      String string0 = usuarioRequest0.getEmail();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      String string0 = usuarioRequest0.getNome();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      String string0 = usuarioRequest0.getSenha();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      String string0 = usuarioRequest0.getEmail();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      usuarioRequest0.setSenha("");
      String string0 = usuarioRequest0.getSenha();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      UsuarioRequest usuarioRequest0 = new UsuarioRequest();
      usuarioRequest0.setNome("");
      String string0 = usuarioRequest0.getNome();
      assertEquals("", string0);
  }
}
