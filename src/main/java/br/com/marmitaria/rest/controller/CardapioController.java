package br.com.marmitaria.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cardapio;
import br.com.marmitaria.persistence.service.CardapioService;
import br.com.marmitaria.persistence.service.MarmitaService;
import br.com.marmitaria.rest.request.CardapioRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/protegido/cardapio")
public class CardapioController {
	
	@Autowired
	private CardapioService cardapioService;
	
	@Autowired
	private MarmitaService marmitaService;
	
	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<Cardapio> cadastrar(@RequestBody CardapioRequest request){
		Validation.valida(request);		
		return null;
	}

}
