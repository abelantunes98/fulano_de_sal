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
import br.com.marmitaria.persistence.service.ClienteService;
import br.com.marmitaria.rest.exception.usuario.SenhaInvalidaException;
import br.com.marmitaria.rest.exception.usuario.EmailJaCadastradoException;
import br.com.marmitaria.rest.exception.usuario.EmailNaoCadastradoException;
import br.com.marmitaria.rest.login.TokenKey;
import br.com.marmitaria.rest.reponse.ClienteResponse;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.request.LoginRequest;
import br.com.marmitaria.rest.util.Validation;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<Cliente> create(@RequestBody ClienteRequest clienteRequest){
		Validation.validaCliente(clienteRequest);
		
		Cliente clienteSave = clienteService.findByEmail(clienteRequest.getEmail());
		
		if(clienteSave != null) {
			throw new EmailJaCadastradoException();
		}
		
		Cliente cliente = clienteService.create(new Cliente(clienteRequest));
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<ClienteResponse> login(@RequestBody LoginRequest login) {
		Validation.validaLogin(login);
		Cliente cliente = this.clienteService.findByEmail(login.getEmail());

		if (cliente == null)
			throw new EmailNaoCadastradoException();
		if (!cliente.getSenha().equals(login.getSenha()))
			throw new SenhaInvalidaException();

		String token = Jwts.builder().setSubject(cliente.getEmail())
				.signWith(SignatureAlgorithm.HS512, TokenKey.TOKEN_KEY.getValue()).setExpiration(new Date(System.currentTimeMillis() + 1800000)).compact();
		HttpHeaders  headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<ClienteResponse> (new ClienteResponse(cliente,"Bearer " + token),HttpStatus.OK);
	}
}
