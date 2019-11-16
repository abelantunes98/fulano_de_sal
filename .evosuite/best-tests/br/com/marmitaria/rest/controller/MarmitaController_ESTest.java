/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:42:04 GMT 2019
 */

package br.com.marmitaria.rest.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.TipoMarmita;
import br.com.marmitaria.persistence.service.GenericService;
import br.com.marmitaria.persistence.service.MarmitaService;
import br.com.marmitaria.rest.controller.MarmitaController;
import br.com.marmitaria.rest.request.MarmitaRequest;
import java.util.List;
import java.util.Optional;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class MarmitaController_ESTest extends MarmitaController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<Integer, String> jpaRepository0 = (JpaRepository<Integer, String>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      MarmitaRequest marmitaRequest0 = new MarmitaRequest();
      marmitaRequest0.setValor(158.446F);
      marmitaRequest0.setTipo(";?BSL1;O}o-J");
      // Undeclared exception!
      try { 
        marmitaController0.cadastra(marmitaRequest0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // No enum constant br.com.marmitaria.persistence.model.TipoMarmita.;?BSL1;O}o-J
         //
         verifyException("java.lang.Enum", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<Integer, Marmita> jpaRepository0 = (JpaRepository<Integer, Marmita>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(jpaRepository0).findAll();
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      // Undeclared exception!
      try { 
        marmitaController0.list();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Collections", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<String, Object> jpaRepository0 = (JpaRepository<String, Object>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      doReturn((Optional<String>) null).when(jpaRepository0).findById(any());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      Long long0 = new Long(0L);
      // Undeclared exception!
      try { 
        marmitaController0.remove(long0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.persistence.service.GenericService", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      Optional<String> optional0 = Optional.of("");
      JpaRepository<String, TipoMarmita> jpaRepository0 = (JpaRepository<String, TipoMarmita>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      doReturn(optional0).when(jpaRepository0).findById(any(br.com.marmitaria.persistence.model.TipoMarmita.class));
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      // Undeclared exception!
      try { 
        marmitaController0.remove((Long) null);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.String cannot be cast to br.com.marmitaria.persistence.model.Marmita
         //
         verifyException("br.com.marmitaria.rest.controller.MarmitaController", e);
      }
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<Object, Object> jpaRepository0 = (JpaRepository<Object, Object>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      // Undeclared exception!
      try { 
        marmitaController0.cadastra((MarmitaRequest) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<TipoMarmita, TipoMarmita> jpaRepository0 = (JpaRepository<TipoMarmita, TipoMarmita>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      // Undeclared exception!
      try { 
        marmitaController0.atualizar((Marmita) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<Object, Integer> jpaRepository0 = (JpaRepository<Object, Integer>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      doReturn((Optional) null).when(jpaRepository0).findById(anyInt());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      // Undeclared exception!
      try { 
        marmitaController0.remove((Long) null);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Marmita n\u00E3o encontrada!
         //
         verifyException("br.com.marmitaria.rest.controller.MarmitaController", e);
      }
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      Marmita marmita0 = new Marmita();
      Optional<Marmita> optional0 = Optional.ofNullable(marmita0);
      JpaRepository<Marmita, Object> jpaRepository0 = (JpaRepository<Marmita, Object>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      doReturn(optional0).when(jpaRepository0).findById(any());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      Long long0 = new Long(0);
      ResponseEntity<Marmita> responseEntity0 = marmitaController0.remove(long0);
      assertEquals(200, responseEntity0.getStatusCodeValue());
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      MarmitaController marmitaController0 = new MarmitaController();
      MarmitaService marmitaService0 = new MarmitaService();
      JpaRepository<Integer, Integer> jpaRepository0 = (JpaRepository<Integer, Integer>) mock(JpaRepository.class, new ViolatedAssumptionAnswer());
      Injector.inject(marmitaService0, (Class<?>) GenericService.class, "dao", (Object) jpaRepository0);
      Injector.validateBean(marmitaService0, (Class<?>) MarmitaService.class);
      Injector.inject(marmitaController0, (Class<?>) MarmitaController.class, "marmitaService", (Object) marmitaService0);
      Injector.validateBean(marmitaController0, (Class<?>) MarmitaController.class);
      MarmitaRequest marmitaRequest0 = new MarmitaRequest();
      // Undeclared exception!
      try { 
        marmitaController0.cadastra(marmitaRequest0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Valor n\u00E3o informado!
         //
         verifyException("br.com.marmitaria.rest.util.Validation", e);
      }
  }
}