/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Sat Oct 26 18:01:09 GMT 2019
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
public class PedidoService_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "br.com.marmitaria.persistence.service.PedidoService"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(PedidoService_ESTest_scaffolding.class.getClassLoader() ,
      "br.com.marmitaria.persistence.model.Pedido",
      "org.springframework.context.annotation.Primary",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.springframework.data.domain.Sort$Direction",
      "org.springframework.data.domain.ExampleMatcher$MatchMode",
      "org.hsqldb.jdbc.JDBCDriver",
      "org.postgresql.util.SharedTimer",
      "br.com.marmitaria.persistence.model.TipoMarmita",
      "org.springframework.data.repository.Repository",
      "br.com.marmitaria.persistence.dao.PedidoDAO",
      "org.springframework.data.domain.Sort",
      "org.springframework.data.domain.Pageable",
      "org.springframework.stereotype.Repository",
      "org.springframework.data.domain.ExampleMatcher$GenericPropertyMatcher",
      "org.hsqldb.jdbc.JDBCDriver$1",
      "br.com.marmitaria.persistence.model.Marmita",
      "org.springframework.data.repository.PagingAndSortingRepository",
      "br.com.marmitaria.persistence.model.Categoria",
      "org.h2.Driver",
      "org.springframework.util.function.SingletonSupplier",
      "org.springframework.data.domain.Page",
      "org.springframework.data.domain.Example",
      "org.springframework.data.domain.Slice",
      "org.springframework.data.domain.Sort$NullHandling",
      "org.springframework.data.domain.ExampleMatcher$MatcherConfigurer",
      "org.springframework.data.util.Streamable",
      "br.com.marmitaria.persistence.model.Cliente",
      "org.springframework.data.domain.ExampleMatcher$StringMatcher",
      "org.springframework.data.jpa.repository.JpaRepository",
      "br.com.marmitaria.persistence.model.Usuario",
      "br.com.marmitaria.persistence.service.GenericService",
      "org.postgresql.util.HostSpec",
      "br.com.marmitaria.rest.request.UsuarioRequest",
      "org.postgresql.util.ServerErrorMessage",
      "org.springframework.data.repository.CrudRepository",
      "org.postgresql.util.PSQLException",
      "org.springframework.data.repository.NoRepositoryBean",
      "org.springframework.data.domain.ExampleMatcher$PropertySpecifiers",
      "org.postgresql.util.ExpressionProperties",
      "org.springframework.stereotype.Service",
      "br.com.marmitaria.persistence.model.TipoPagamento",
      "org.postgresql.util.WriterHandler",
      "org.springframework.stereotype.Indexed",
      "org.h2.JdbcDriverBackwardsCompat",
      "org.springframework.data.domain.ExampleMatcher",
      "org.springframework.data.util.Lazy",
      "br.com.marmitaria.persistence.service.PedidoService",
      "br.com.marmitaria.rest.request.ClienteRequest",
      "org.springframework.data.domain.Sort$Order",
      "org.springframework.data.repository.query.QueryByExampleExecutor",
      "br.com.marmitaria.persistence.model.TipoUsuario",
      "org.springframework.data.domain.ExampleMatcher$PropertyValueTransformer",
      "org.springframework.stereotype.Component",
      "br.com.marmitaria.persistence.model.Produto",
      "org.springframework.data.domain.ExampleMatcher$NullHandler",
      "org.springframework.util.Assert",
      "org.postgresql.Driver"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("br.com.marmitaria.persistence.dao.PedidoDAO", false, PedidoService_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("org.springframework.data.jpa.repository.JpaRepository", false, PedidoService_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(PedidoService_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "br.com.marmitaria.persistence.service.GenericService",
      "br.com.marmitaria.persistence.service.PedidoService",
      "br.com.marmitaria.persistence.model.Pedido",
      "br.com.marmitaria.persistence.model.Marmita",
      "br.com.marmitaria.rest.request.UsuarioRequest",
      "br.com.marmitaria.rest.request.ClienteRequest",
      "br.com.marmitaria.persistence.model.Usuario",
      "br.com.marmitaria.persistence.model.Cliente",
      "br.com.marmitaria.persistence.model.Produto",
      "org.postgresql.util.SharedTimer",
      "org.postgresql.Driver",
      "org.h2.Driver",
      "org.hsqldb.jdbc.JDBCDriver",
      "org.springframework.data.util.Lazy",
      "org.springframework.util.Assert",
      "org.springframework.util.function.SingletonSupplier",
      "br.com.marmitaria.persistence.model.TipoUsuario"
    );
  }
}