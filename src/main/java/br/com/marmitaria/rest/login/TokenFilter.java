package br.com.marmitaria.rest.login;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import br.com.marmitaria.rest.exception.TokenException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class TokenFilter extends GenericFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5607986703246617499L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String header = req.getHeader("Authorization");

		if (header == null || !header.startsWith("Bearer ")) {
			throw new TokenException("Token inexistente ou mal formatado!");
		}

		String token = header.substring(7);

		try {
			Jwts.parser().setSigningKey(TokenKey.TOKEN_KEY.getValue()).parseClaimsJws(token).getBody();
		} catch (SignatureException e) {
			throw new TokenException("Token invalido ou expirado!");
		}

		chain.doFilter(request, response);

	}

}
