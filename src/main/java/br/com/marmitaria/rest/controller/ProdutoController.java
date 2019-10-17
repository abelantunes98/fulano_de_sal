package br.com.marmitaria.rest.controller;

import java.util.Collections;
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

import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.persistence.service.CategoriaService;
import br.com.marmitaria.persistence.service.ProdutoService;
import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.request.ProdutoRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("protegido/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@ApiOperation("Cadastra um Produto")
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<Produto> cadastra(@RequestBody ProdutoRequest produtoRequest) {
		Validation.valida(produtoRequest);
		
		Categoria categoria = categoriaService.findById(produtoRequest.getIdCategoria());
		Produto produto = produtoService.findByNome(produtoRequest.getNome());
		if(produto != null && produto.getCategoria().equals(categoria)) {
			throw new DadosInvalidosException(String.format("Produto: %s já cadastrado.", produto.getNome()));
		}
		produto = new Produto();
		produto.setCategoria(categoria);
		produto.setNome(produtoRequest.getNome());
		
		produto = produtoService.salvar(produto);
		return new ResponseEntity<Produto>(produto,HttpStatus.OK);
	}
	
	@ApiOperation("Remove um produto")
	@DeleteMapping("/remover")
	@ResponseBody
	public ResponseEntity<Produto> remover(@RequestParam("id") Long id) {
		Produto produto = produtoService.findById(id);
		if(produto==null) {
			throw new NotFoundException("Produto não cadastrado!");
		}
		try {
			produtoService.deletar(produto);
		}catch (Exception e) {
			throw new DadosInvalidosException("O produto não pode ser removido!");
		}
		return new ResponseEntity<Produto>(HttpStatus.OK);
	}
	
	@ApiOperation("Retorna lista de produtos")
	@GetMapping("/listar")
	@ResponseBody
	public ResponseEntity<List<Produto>> lista(){
		List<Produto> produtos = produtoService.findAll();
		Collections.sort(produtos);
		return new ResponseEntity<List<Produto>>(produtos,HttpStatus.OK);
	}
	
	@ApiOperation("Retorna lista de produtos da categoria informada")
	@GetMapping("/listarPorCategoria")
	@ResponseBody
	public ResponseEntity<List<Produto>> listaPorCategoria(@RequestParam("idCategoria") Long idCategoria) {
		Categoria categoria = categoriaService.findById(idCategoria);
		if(categoria==null) {
			throw new DadosInvalidosException("Categoria não encontrada!");
		}
		List<Produto> produtos = produtoService.findByCategoria(categoria);
		Collections.sort(produtos);
		return new ResponseEntity<List<Produto>>(produtos,HttpStatus.OK);
	}
	
	@ApiOperation("Atualiza um produto")
	@PostMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produtoRequest) {
		Validation.valida(produtoRequest);
		Produto produto = produtoService.findById(produtoRequest.getIdProduto());
		if(produto==null) {
			throw new NotFoundException("Produto não encontrado!");
		}
		produto = produtoService.atualizar(produtoRequest);
		return new ResponseEntity<Produto>(produto,HttpStatus.OK);
	}
}
