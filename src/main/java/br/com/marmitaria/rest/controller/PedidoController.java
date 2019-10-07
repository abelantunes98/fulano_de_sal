package br.com.marmitaria.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Pedido;
import br.com.marmitaria.persistence.service.PedidoService;
import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/protegido/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	
	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<Pedido> cadastrar(){
		return null;
	}
}


