/*
 * This file was automatically generated by EvoSuite
 * Sat Oct 26 17:46:43 GMT 2019
 */

package br.com.marmitaria.rest.login;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import br.com.marmitaria.rest.login.TokenFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.filters.ExpiresFilter;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockFilterChain;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class TokenFilter_ESTest extends TokenFilter_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      TokenFilter tokenFilter0 = new TokenFilter();
      Connector connector0 = new Connector((String) null);
      Request request0 = connector0.createRequest();
      HttpServletRequest httpServletRequest0 = request0.getRequest();
      Response response0 = connector0.createResponse();
      // Undeclared exception!
      try { 
        tokenFilter0.doFilter(httpServletRequest0, response0, (FilterChain) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.catalina.connector.Request", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      TokenFilter tokenFilter0 = new TokenFilter();
      Connector connector0 = new Connector("x;:6mWx");
      Request request0 = new Request(connector0);
      ServletRequestWrapper servletRequestWrapper0 = new ServletRequestWrapper(request0);
      ExpiresFilter expiresFilter0 = new ExpiresFilter();
      Response response0 = new Response(2778);
      ExpiresFilter.XHttpServletResponse expiresFilter_XHttpServletResponse0 = expiresFilter0.new XHttpServletResponse(request0, response0);
      // Undeclared exception!
      try { 
        tokenFilter0.doFilter(servletRequestWrapper0, expiresFilter_XHttpServletResponse0, (FilterChain) null);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // javax.servlet.ServletRequestWrapper cannot be cast to javax.servlet.http.HttpServletRequest
         //
         verifyException("br.com.marmitaria.rest.login.TokenFilter", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      TokenFilter tokenFilter0 = new TokenFilter();
      Connector connector0 = new Connector();
      Request request0 = connector0.createRequest();
      org.apache.coyote.Request request1 = new org.apache.coyote.Request();
      request0.setCoyoteRequest(request1);
      Response response0 = connector0.createResponse();
      MockFilterChain mockFilterChain0 = new MockFilterChain();
      // Undeclared exception!
      try { 
        tokenFilter0.doFilter(request0, response0, mockFilterChain0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // Token inexistente ou mal formatado!
         //
         verifyException("br.com.marmitaria.rest.login.TokenFilter", e);
      }
  }
}