/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:57:59 GMT 2019
 */

package br.com.marmitaria.rest.exception;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.marmitaria.rest.exception.DadosInvalidosException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class DadosInvalidosException_ESTest extends DadosInvalidosException_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      DadosInvalidosException dadosInvalidosException0 = new DadosInvalidosException("");
  }
}
