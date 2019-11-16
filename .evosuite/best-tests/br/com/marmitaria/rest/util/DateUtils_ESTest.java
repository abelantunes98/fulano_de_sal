/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:53:43 GMT 2019
 */

package br.com.marmitaria.rest.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.marmitaria.rest.util.DateUtils;
import java.util.Date;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.mock.java.util.MockDate;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DateUtils_ESTest extends DateUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MockDate mockDate0 = new MockDate((-743), (-743), (-743));
      String string0 = DateUtils.newDate((Date) mockDate0);
      assertEquals("17/01/1093 21:00:00", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      // Undeclared exception!
      try { 
        DateUtils.newDate((Date) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      String string0 = DateUtils.newDate();
      assertEquals("14/02/2014 17:21:21", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      DateUtils dateUtils0 = new DateUtils();
  }
}