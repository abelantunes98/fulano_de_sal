/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Sat Oct 26 17:26:16 GMT 2019
 */

package br.com.marmitaria.rest.controller;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class PublicoCotroller_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "br.com.marmitaria.rest.controller.PublicoCotroller"; 
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
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(PublicoCotroller_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.data.repository.query.Param",
      "io.jsonwebtoken.lang.UnknownClassException",
      "org.springframework.data.domain.ExampleMatcher$PropertySpecifier",
      "br.com.marmitaria.rest.exception.usuario.UsuarioInvalidoException",
      "org.springframework.http.ContentDisposition$Builder",
      "org.springframework.beans.factory.annotation.Autowired",
      "io.jsonwebtoken.lang.InstantiationException",
      "org.springframework.http.CacheControl",
      "org.springframework.data.domain.Sort$Direction",
      "org.hsqldb.jdbc.JDBCDriver",
      "org.postgresql.util.SharedTimer",
      "br.com.marmitaria.persistence.model.TipoMarmita",
      "io.jsonwebtoken.SignatureException",
      "io.jsonwebtoken.SignatureAlgorithm",
      "org.springframework.data.domain.Sort",
      "org.springframework.stereotype.Repository",
      "br.com.marmitaria.rest.login.TokenKey",
      "br.com.marmitaria.rest.request.MarmitaRequest",
      "org.springframework.data.domain.ExampleMatcher$GenericPropertyMatcher",
      "org.hsqldb.jdbc.JDBCDriver$1",
      "br.com.marmitaria.persistence.model.Marmita",
      "br.com.marmitaria.rest.exception.MailNotSendException",
      "br.com.marmitaria.rest.exception.usuario.EmailNaoCadastradoException",
      "org.springframework.data.repository.PagingAndSortingRepository",
      "br.com.marmitaria.persistence.service.UsuarioService",
      "org.springframework.util.function.SingletonSupplier",
      "org.springframework.data.domain.Page",
      "br.com.marmitaria.rest.request.ConfirmacaoDeCodigoRequest",
      "org.springframework.web.bind.annotation.RestController",
      "org.springframework.data.domain.TypedExample",
      "org.springframework.data.domain.ExampleMatcher$NoOpPropertyValueTransformer",
      "io.jsonwebtoken.lang.Classes$ClassLoaderAccessor",
      "br.com.marmitaria.persistence.service.RecuperacaoService",
      "br.com.marmitaria.rest.exception.usuario.SenhaInvalidaException",
      "org.springframework.data.util.Streamable",
      "org.springframework.util.CollectionUtils",
      "org.springframework.data.domain.ExampleMatcher$StringMatcher",
      "org.springframework.data.domain.ExampleMatcher$GenericPropertyMatchers",
      "br.com.marmitaria.rest.exception.usuario.EmailJaCadastradoException",
      "org.springframework.data.jpa.repository.Query",
      "br.com.marmitaria.persistence.service.GenericService",
      "br.com.marmitaria.rest.request.CardapioRequest",
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.springframework.http.HttpStatus$Series",
      "org.springframework.http.MediaType$1",
      "org.postgresql.util.ServerErrorMessage",
      "br.com.marmitaria.rest.exception.DadosInvalidosException",
      "org.postgresql.util.PSQLException",
      "org.springframework.data.repository.NoRepositoryBean",
      "org.postgresql.util.ExpressionProperties",
      "br.com.marmitaria.rest.request.CategoriaRequest",
      "org.springframework.stereotype.Service",
      "io.jsonwebtoken.lang.Classes",
      "br.com.marmitaria.persistence.model.TipoPagamento",
      "org.postgresql.util.WriterHandler",
      "org.springframework.util.MimeType$SpecificityComparator",
      "br.com.marmitaria.persistence.dao.UsuarioDAO",
      "org.springframework.stereotype.Indexed",
      "io.swagger.annotations.Api",
      "br.com.marmitaria.rest.util.Validation",
      "org.springframework.util.InvalidMimeTypeException",
      "br.com.marmitaria.rest.request.ProdutoRequest",
      "io.jsonwebtoken.lang.Classes$1",
      "io.jsonwebtoken.lang.Classes$2",
      "io.jsonwebtoken.lang.Classes$3",
      "org.springframework.util.ObjectUtils",
      "org.springframework.http.HttpMethod",
      "org.springframework.util.MultiValueMap",
      "org.springframework.data.domain.ExampleMatcher",
      "org.springframework.util.CollectionUtils$MultiValueMapAdapter",
      "br.com.marmitaria.rest.request.AdministradorRequest",
      "br.com.marmitaria.persistence.model.Recuperacao$Builder",
      "org.springframework.util.LinkedCaseInsensitiveMap$1",
      "br.com.marmitaria.persistence.model.TipoUsuario",
      "org.springframework.http.HttpStatus",
      "org.springframework.data.domain.ExampleMatcher$PropertyValueTransformer",
      "br.com.marmitaria.persistence.model.Produto",
      "br.com.marmitaria.persistence.dao.RecuperacaoDAO",
      "io.jsonwebtoken.JwtException",
      "org.springframework.data.domain.ExampleMatcher$NullHandler",
      "org.springframework.util.LinkedMultiValueMap",
      "org.postgresql.Driver",
      "org.springframework.context.annotation.Primary",
      "org.springframework.data.geo.Metrics",
      "org.springframework.data.annotation.QueryAnnotation",
      "org.springframework.data.domain.ExampleMatcher$MatchMode",
      "org.springframework.util.MimeType",
      "br.com.marmitaria.rest.request.RecuperacaoRequest",
      "org.springframework.data.repository.Repository",
      "br.com.marmitaria.rest.controller.PublicoCotroller",
      "org.springframework.data.domain.Pageable",
      "io.swagger.annotations.AuthorizationScope",
      "org.springframework.http.HttpHeaders",
      "org.springframework.http.MediaType",
      "org.springframework.web.bind.annotation.RequestMethod",
      "br.com.marmitaria.persistence.model.Categoria",
      "org.h2.Driver",
      "org.springframework.data.domain.Example",
      "org.springframework.data.domain.Slice",
      "org.springframework.data.domain.Sort$NullHandling",
      "org.springframework.http.HttpEntity",
      "org.springframework.data.domain.ExampleMatcher$MatcherConfigurer",
      "br.com.marmitaria.persistence.model.Cliente",
      "org.springframework.data.domain.TypedExampleMatcher",
      "org.springframework.http.ResponseEntity$HeadersBuilder",
      "org.springframework.data.jpa.repository.JpaRepository",
      "br.com.marmitaria.rest.exception.UsuarioNaoEncontradoException",
      "org.springframework.data.geo.Metric",
      "br.com.marmitaria.persistence.model.Usuario",
      "org.postgresql.util.HostSpec",
      "io.jsonwebtoken.lang.RuntimeEnvironment",
      "br.com.marmitaria.rest.request.UsuarioRequest",
      "org.springframework.web.bind.annotation.RequestMapping",
      "org.springframework.stereotype.Controller",
      "org.springframework.http.ResponseEntity$BodyBuilder",
      "org.springframework.data.repository.CrudRepository",
      "org.springframework.http.ReadOnlyHttpHeaders",
      "br.com.marmitaria.rest.exception.notFound.NotFoundException",
      "br.com.marmitaria.rest.request.LoginRequest",
      "org.springframework.data.domain.ExampleMatcher$PropertySpecifiers",
      "br.com.marmitaria.rest.reponse.UsuarioResponse",
      "org.springframework.http.ContentDisposition",
      "br.com.marmitaria.rest.exception.notFound.RecuperacaoNaoEncontradaException",
      "br.com.marmitaria.persistence.dao.ClienteDAO",
      "br.com.marmitaria.persistence.model.Recuperacao",
      "org.h2.JdbcDriverBackwardsCompat",
      "org.springframework.util.MimeTypeUtils",
      "org.springframework.web.bind.annotation.ResponseBody",
      "org.springframework.data.util.Lazy",
      "br.com.marmitaria.rest.request.ClienteRequest",
      "org.springframework.data.domain.Sort$Order",
      "org.springframework.data.repository.query.QueryByExampleExecutor",
      "org.springframework.http.InvalidMediaTypeException",
      "org.springframework.stereotype.Component",
      "br.com.marmitaria.rest.request.PedidoRequest",
      "org.springframework.http.ResponseEntity",
      "br.com.marmitaria.persistence.service.ClienteService",
      "io.swagger.annotations.Authorization",
      "org.springframework.web.bind.annotation.Mapping",
      "org.springframework.util.Assert",
      "io.jsonwebtoken.lang.Classes$ExceptionIgnoringAccessor",
      "org.springframework.util.StringUtils"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("br.com.marmitaria.persistence.dao.ClienteDAO", false, PublicoCotroller_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("br.com.marmitaria.persistence.dao.RecuperacaoDAO", false, PublicoCotroller_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("br.com.marmitaria.persistence.dao.UsuarioDAO", false, PublicoCotroller_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("br.com.marmitaria.persistence.model.Recuperacao", false, PublicoCotroller_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("org.springframework.data.jpa.repository.JpaRepository", false, PublicoCotroller_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(PublicoCotroller_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "br.com.marmitaria.rest.controller.PublicoCotroller",
      "br.com.marmitaria.rest.util.Validation",
      "org.springframework.http.HttpStatus",
      "io.jsonwebtoken.lang.Classes$ExceptionIgnoringAccessor",
      "io.jsonwebtoken.lang.Classes$1",
      "io.jsonwebtoken.lang.Classes$2",
      "io.jsonwebtoken.lang.Classes$3",
      "io.jsonwebtoken.lang.Classes",
      "io.jsonwebtoken.lang.UnknownClassException",
      "io.jsonwebtoken.lang.RuntimeEnvironment",
      "io.jsonwebtoken.SignatureAlgorithm",
      "br.com.marmitaria.rest.login.TokenKey",
      "br.com.marmitaria.persistence.model.TipoUsuario",
      "br.com.marmitaria.persistence.service.GenericService",
      "br.com.marmitaria.persistence.service.ClienteService",
      "br.com.marmitaria.persistence.service.RecuperacaoService",
      "br.com.marmitaria.persistence.service.UsuarioService",
      "br.com.marmitaria.rest.request.UsuarioRequest",
      "br.com.marmitaria.rest.request.ClienteRequest",
      "br.com.marmitaria.rest.exception.DadosInvalidosException",
      "br.com.marmitaria.rest.request.RecuperacaoRequest",
      "br.com.marmitaria.persistence.model.Usuario",
      "br.com.marmitaria.persistence.model.Cliente",
      "br.com.marmitaria.rest.request.ConfirmacaoDeCodigoRequest",
      "br.com.marmitaria.rest.exception.notFound.NotFoundException",
      "br.com.marmitaria.rest.exception.UsuarioNaoEncontradoException",
      "org.springframework.http.ReadOnlyHttpHeaders",
      "org.springframework.util.LinkedMultiValueMap",
      "org.springframework.util.Assert",
      "org.springframework.http.HttpHeaders",
      "org.springframework.util.LinkedCaseInsensitiveMap",
      "org.springframework.util.LinkedCaseInsensitiveMap$1",
      "org.springframework.util.CollectionUtils",
      "org.springframework.util.CollectionUtils$MultiValueMapAdapter",
      "org.springframework.http.HttpEntity",
      "org.springframework.http.ResponseEntity",
      "br.com.marmitaria.rest.request.LoginRequest",
      "br.com.marmitaria.persistence.model.Recuperacao",
      "org.postgresql.util.SharedTimer",
      "org.postgresql.Driver",
      "org.h2.Driver",
      "org.hsqldb.jdbc.JDBCDriver",
      "br.com.marmitaria.rest.reponse.UsuarioResponse",
      "br.com.marmitaria.rest.exception.notFound.RecuperacaoNaoEncontradaException",
      "org.springframework.data.util.Lazy",
      "org.springframework.data.domain.TypedExampleMatcher",
      "org.springframework.data.domain.ExampleMatcher$NullHandler",
      "org.springframework.data.domain.ExampleMatcher$StringMatcher",
      "org.springframework.data.domain.ExampleMatcher$PropertySpecifiers",
      "org.springframework.data.domain.ExampleMatcher$MatchMode",
      "org.springframework.data.domain.TypedExample",
      "org.springframework.util.StringUtils",
      "org.springframework.data.domain.ExampleMatcher$PropertySpecifier",
      "org.springframework.util.function.SingletonSupplier",
      "org.springframework.util.ObjectUtils",
      "org.springframework.data.domain.ExampleMatcher$GenericPropertyMatcher"
    );
  }
}
