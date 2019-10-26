/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Sat Oct 26 17:54:03 GMT 2019
 */

package br.com.marmitaria.persistence.service;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class RecuperacaoService_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "br.com.marmitaria.persistence.service.RecuperacaoService"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "/tmp"); 
    java.lang.System.setProperty("user.country", "BR"); 
    java.lang.System.setProperty("user.dir", "/home/rickecr/Documentos/fulano-de-sal"); 
    java.lang.System.setProperty("user.home", "/home/rickecr"); 
    java.lang.System.setProperty("user.language", "pt"); 
    java.lang.System.setProperty("user.name", "rickecr"); 
    java.lang.System.setProperty("user.timezone", "America/Fortaleza"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(RecuperacaoService_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.data.repository.query.Param",
      "org.springframework.context.annotation.Primary",
      "org.springframework.data.domain.ExampleMatcher$PropertySpecifier",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.springframework.data.annotation.QueryAnnotation",
      "org.springframework.data.domain.Sort$Direction",
      "org.springframework.data.domain.ExampleMatcher$MatchMode",
      "org.hsqldb.jdbc.JDBCDriver",
      "org.postgresql.util.SharedTimer",
      "org.springframework.data.repository.Repository",
      "org.springframework.data.domain.Sort",
      "org.springframework.data.domain.Pageable",
      "org.springframework.stereotype.Repository",
      "org.springframework.data.domain.ExampleMatcher$GenericPropertyMatcher",
      "org.hsqldb.jdbc.JDBCDriver$1",
      "org.springframework.data.repository.PagingAndSortingRepository",
      "org.springframework.util.function.SingletonSupplier",
      "org.h2.Driver",
      "org.springframework.data.domain.Page",
      "org.springframework.data.domain.Example",
      "org.springframework.data.domain.Slice",
      "org.springframework.data.domain.Sort$NullHandling",
      "br.com.marmitaria.persistence.service.RecuperacaoService",
      "org.springframework.data.domain.ExampleMatcher$MatcherConfigurer",
      "org.springframework.data.util.Streamable",
      "org.springframework.data.domain.ExampleMatcher$StringMatcher",
      "org.springframework.data.jpa.repository.JpaRepository",
      "br.com.marmitaria.persistence.model.Usuario",
      "org.springframework.data.jpa.repository.Query",
      "br.com.marmitaria.persistence.service.GenericService",
      "org.postgresql.util.HostSpec",
      "org.postgresql.util.ServerErrorMessage",
      "org.springframework.data.repository.CrudRepository",
      "org.postgresql.util.PSQLException",
      "org.springframework.data.repository.NoRepositoryBean",
      "org.springframework.data.domain.ExampleMatcher$PropertySpecifiers",
      "org.postgresql.util.ExpressionProperties",
      "org.springframework.stereotype.Service",
      "org.postgresql.util.WriterHandler",
      "org.springframework.stereotype.Indexed",
      "br.com.marmitaria.persistence.model.Recuperacao",
      "org.h2.JdbcDriverBackwardsCompat",
      "org.springframework.data.domain.ExampleMatcher",
      "org.springframework.data.util.Lazy",
      "org.springframework.data.domain.Sort$Order",
      "br.com.marmitaria.persistence.model.Recuperacao$Builder",
      "org.springframework.data.repository.query.QueryByExampleExecutor",
      "br.com.marmitaria.persistence.model.TipoUsuario",
      "org.springframework.data.domain.ExampleMatcher$PropertyValueTransformer",
      "org.springframework.stereotype.Component",
      "br.com.marmitaria.persistence.dao.RecuperacaoDAO",
      "org.springframework.data.domain.ExampleMatcher$NullHandler",
      "org.springframework.util.Assert",
      "org.postgresql.Driver"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("br.com.marmitaria.persistence.dao.RecuperacaoDAO", false, RecuperacaoService_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("org.springframework.data.jpa.repository.JpaRepository", false, RecuperacaoService_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(RecuperacaoService_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "br.com.marmitaria.persistence.service.GenericService",
      "br.com.marmitaria.persistence.service.RecuperacaoService",
      "br.com.marmitaria.persistence.model.Recuperacao",
      "br.com.marmitaria.persistence.model.Usuario",
      "br.com.marmitaria.persistence.model.Recuperacao$Builder",
      "org.springframework.util.function.SingletonSupplier",
      "org.springframework.data.util.Lazy",
      "org.springframework.util.Assert",
      "org.postgresql.util.SharedTimer",
      "org.postgresql.Driver",
      "org.h2.Driver",
      "org.hsqldb.jdbc.JDBCDriver"
    );
  }
}
