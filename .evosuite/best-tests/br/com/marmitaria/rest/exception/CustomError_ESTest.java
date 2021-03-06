/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:49:23 GMT 2019
 */

package br.com.marmitaria.rest.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.marmitaria.rest.exception.CustomError;
import java.util.Date;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class CustomError_ESTest extends CustomError_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MockDate mockDate0 = new MockDate(1L);
      CustomError customError0 = new CustomError(mockDate0, (String) null);
      customError0.setMessage("lL)?1c");
      String string0 = customError0.getMessage();
      assertEquals("lL)?1c", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      MockDate mockDate0 = new MockDate(1L);
      CustomError customError0 = new CustomError(mockDate0, (String) null);
      Date date0 = customError0.getDate();
      assertSame(date0, mockDate0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      CustomError customError0 = new CustomError((Date) null, "");
      customError0.setDate((Date) null);
      assertEquals("", customError0.getMessage());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      CustomError customError0 = new CustomError((Date) null, "");
      customError0.setMessage((String) null);
      String string0 = customError0.getMessage();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      CustomError customError0 = new CustomError((Date) null, "");
      String string0 = customError0.getMessage();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      CustomError customError0 = new CustomError((Date) null, "");
      Date date0 = customError0.getDate();
      assertNull(date0);
  }
}
