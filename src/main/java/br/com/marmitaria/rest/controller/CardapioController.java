package br.com.marmitaria.rest.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cardapio;
import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.persistence.service.CardapioService;
import br.com.marmitaria.persistence.service.CategoriaService;
import br.com.marmitaria.persistence.service.ProdutoService;
import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.reponse.CardapioRespose;
import br.com.marmitaria.rest.reponse.ProdutoResponse;
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
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaService  categoriaService;
	
	@ApiOperation("Cadastra um cardápio")
	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<Cardapio> cadastrar(@RequestBody CardapioRequest request){
		Validation.valida(request);	
		Cardapio cardapio = new Cardapio();
		List<Cardapio> cardapios = cardapioService.findAll();
		
		if(cardapios!=null && !cardapios.isEmpty()) {
			cardapio = cardapios.get(0);
		}
		
		cardapio.setProdutos(new ArrayList<Produto>());
		
		for(Long id : request.getIdProdutos()) {
			Produto produto  = produtoService.findById(id);
			if(produto==null) {
				throw new  NotFoundException("O Cardápio possui produtos não cadastrados!");
			}
			cardapio.getProdutos().add(produto);
		}
		cardapio.setData(new Date());
		cardapio.setLiberado(false);
		cardapio = cardapioService.salvar(cardapio);
		
		return new ResponseEntity<Cardapio>(cardapio,HttpStatus.OK);
	}
	
	
	@ApiOperation("Retorna o último cardápio")
	@ResponseBody
	@GetMapping("/ultimo")
	public ResponseEntity<CardapioRespose> cardapioDoDia() {
		Cardapio retorno = null;
		CardapioRespose cardapioRespose = null;
		Cardapio cardapio = cardapioService.findByLiberado(true);
		if(cardapio != null) {
			retorno = cardapio;
			cardapioRespose = new CardapioRespose(retorno);
		}
		return new ResponseEntity<CardapioRespose>(cardapioRespose, HttpStatus.OK);
	}
	
	@ApiOperation("Liberar o último cardápio")
	@ResponseBody
	@GetMapping("/liberar")
	public ResponseEntity<CardapioRespose> liberarCardapioDoDia() {
		Cardapio cardapio = cardapioService.findByLiberado(false);;
		if(cardapio != null) {
			cardapio.setLiberado(true);
			cardapioService.atualizar(cardapio);
		}
		return new ResponseEntity<CardapioRespose>(HttpStatus.OK);
	}
	
	@ApiOperation("Bloquear o último cardápio")
	@ResponseBody
	@GetMapping("/bloquear")
	public ResponseEntity<CardapioRespose> bloquearCardapioDoDia() {
		Cardapio cardapio = cardapioService.findByLiberado(true);
		if(cardapio != null) {
			cardapio.setLiberado(false);
			cardapioService.atualizar(cardapio);
		}
		return new ResponseEntity<CardapioRespose>(HttpStatus.OK);
	}
	
	
	
	@ApiOperation("Retorna o último cardápio por categoria")
	@ResponseBody
	@GetMapping("/ultimoPorCategoria")
	public ResponseEntity<List<ProdutoResponse>> ultimoPorCategoria(@RequestParam("idCategoria") Long id) {
		Cardapio cardapio = null;
		List<Cardapio> cardapios = cardapioService.findAll();
		List<ProdutoResponse> produtos = new ArrayList<>();
		Categoria categoria = categoriaService.findById(id);
		if(categoria==null) throw new NotFoundException("Categoria não cadastrada!");
		if(cardapios != null && !cardapios.isEmpty()) {
			cardapio = cardapios.get(0);
			for(Produto produto: cardapio.getProdutos()){
				if(produto.getCategoria().equals(categoria)){
					produtos.add(new ProdutoResponse(produto));
				}
			}
		}
		return new ResponseEntity<List<ProdutoResponse>>(produtos, HttpStatus.OK);
	}
	
	
	@ApiOperation("Remove o cardapio do dia")
	@DeleteMapping("/remover")
	public void removeCardapio(){
		cardapioService.deleteAll();
	}

}
