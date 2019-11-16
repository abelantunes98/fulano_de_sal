/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:49:14 GMT 2019
 */

package br.com.marmitaria.persistence.service;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import br.com.marmitaria.persistence.service.GenericService;
import br.com.marmitaria.persistence.service.MarmitaService;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.JpaRepository;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MarmitaService_ESTest extends MarmitaService_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<Object, String> jpaRepository0 = (JpaRepository<Object, String>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
  }
}