package br.com.marmitaria.rest.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cardapio;
import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.persistence.service.CardapioService;
import br.com.marmitaria.persistence.service.MarmitaService;
import br.com.marmitaria.persistence.service.ProdutoService;
import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.request.CardapioRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/protegido/cardapio")
public class CardapioController {
	
	@Autowired
	private CardapioService cardapioService;
	
	@Autowired
	private MarmitaService marmitaService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@ApiOperation("Cadastra um cardápio")
	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<Cardapio> cadastrar(@RequestBody CardapioRequest request){
		Validation.valida(request);	
		Cardapio cardapio = new Cardapio();
		
		Marmita marmita = marmitaService.findById(request.getIdMarmita());
		if(marmita==null) throw new NotFoundException("O cardápio possui marmita inválida!");
		
		cardapio.setProdutos(new ArrayList<Produto>());
		
		for(Long id : request.getIdProdutos()) {
			Produto produto  = produtoService.findById(id);
			if(produto==null) {
				throw new  NotFoundException("O Cardápio possui produtos não cadastrados!");
			}
			cardapio.getProdutos().add(produto);
		}
		cardapio.setData(new Date());
		cardapio = cardapioService.salvar(cardapio);
		
		return new ResponseEntity<Cardapio>(cardapio,HttpStatus.OK);
	}
	
	
	@ApiOperation("Retorna o último cardápio")
	@ResponseBody
	@GetMapping("/ultimo")
	public ResponseEntity<Cardapio> cardapioDoDia() {
		Cardapio retorno = null;
		List<Cardapio> cardapios = cardapioService.findAll();
		if(cardapios != null && !cardapios.isEmpty()) {
			retorno = cardapios.get(cardapios.size()-1);
		}
		return new ResponseEntity<Cardapio>(retorno, HttpStatus.OK);
	}

}
