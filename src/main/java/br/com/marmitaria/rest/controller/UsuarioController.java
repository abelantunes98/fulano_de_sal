package br.com.marmitaria.rest.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.model.Tipo;
import br.com.marmitaria.persistence.model.Usuario;
import br.com.marmitaria.persistence.service.UsuarioService;
import br.com.marmitaria.rest.exception.usuario.EmailNaoCadastradoException;
import br.com.marmitaria.rest.exception.usuario.SenhaInvalidaException;
import br.com.marmitaria.rest.login.TokenKey;
import br.com.marmitaria.rest.reponse.ClienteResponse;
import br.com.marmitaria.rest.reponse.UsuarioResponse;
import br.com.marmitaria.rest.request.LoginRequest;
import br.com.marmitaria.rest.util.Validation;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Responsável por atender requisições genericas de usuários")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation("Realiza Login")
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<UsuarioResponse> login(@RequestBody LoginRequest login) {
		Validation.validaLogin(login);
		Usuario usuario = this.usuarioService.findByEmail(login.getEmail());

		if (usuario == null)
			throw new EmailNaoCadastradoException();
		if (!usuario.getSenha().equals(login.getSenha()))
			throw new SenhaInvalidaException();

		String token = Jwts.builder().setSubject(usuario.getEmail())
				.signWith(SignatureAlgorithm.HS512, TokenKey.TOKEN_KEY.getValue()).setExpiration(new Date(System.currentTimeMillis() + 1800000)).compact();
		HttpHeaders  headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		
		ResponseEntity<UsuarioResponse> responseEntity = null;
		if(usuario.getTipo().equals(Tipo.CLIENTE)) {
			responseEntity = new ResponseEntity<UsuarioResponse> (new ClienteResponse((Cliente)usuario,"Bearer " + token),HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<UsuarioResponse> (new UsuarioResponse(usuario,"Bearer " + token),HttpStatus.OK);
		}
		return responseEntity;
	}
	
}
