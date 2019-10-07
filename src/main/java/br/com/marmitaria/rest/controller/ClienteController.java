package br.com.marmitaria.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.service.ClienteService;
import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/protegido/cliente")
public class ClienteController{

	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation("Realiza a atualização do cadastro")
	@PostMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Cliente> atualizaCliente(@RequestBody ClienteRequest request) {
		Validation.validaCliente(request);
		Cliente cliente = clienteService.findByEmail(request.getEmail());
		if(cliente==null) {
			throw new NotFoundException("O Cliente informado não existe");
		}
		cliente.setNome(request.getNome());
		cliente.setEndereco(request.getEndereco());
		cliente.setTelefone(request.getTelefone());
		cliente.setSenha(request.getSenha());
		cliente = clienteService.atualizar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

}
