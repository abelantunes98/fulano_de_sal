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
import br.com.marmitaria.rest.login.LoginResponse;
import br.com.marmitaria.rest.login.TokenKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<Cliente> create(@RequestBody Cliente request){
		Cliente cliente = clienteService.create(request);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<LoginResponse> login(@RequestBody Cliente cliente) {
		Cliente clienteSave = this.clienteService.findByEmail(cliente.getEmail());

		if (clienteSave == null)
			throw new RuntimeException("Usuário não encontrado");
		if (!clienteSave.getSenha().equals(clienteSave.getSenha()))
			throw new RuntimeException("Senha ou login inválido!");

		String token = Jwts.builder().setSubject(clienteSave.getEmail())
				.signWith(SignatureAlgorithm.HS512, TokenKey.TOKEN_KEY.getValue()).setExpiration(new Date(System.currentTimeMillis() + 1800000)).compact();
		HttpHeaders  headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<LoginResponse> (new LoginResponse("Bearer " + token),HttpStatus.OK);
	}
}
