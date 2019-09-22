package br.com.marmitaria.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Categoria;
import br.com.marmitaria.persistence.service.CategoriaService;
import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.request.CategoriaRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("protegido/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;

	@ApiOperation("Cadastra categoria")
	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<Categoria> cadastrar(@RequestBody CategoriaRequest categoriaRequest) {
		Validation.valida(categoriaRequest);
		
		Categoria categoria = service.findByDescricao(categoriaRequest.getDescricao());
		if(categoria!=null) {
			throw new DadosInvalidosException("Categoria já existente.");
		}
		categoria = new Categoria(categoriaRequest.getDescricao());
		categoria = service.salvar(categoria);
		return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);
	}
	
	@ApiOperation("Remove uma categoria")
	@DeleteMapping("/remove")
	public ResponseEntity<Categoria> remover(@RequestParam("id") Long id) {
		Categoria categoria = service.findById(id);
		if (categoria==null) {
			throw new NotFoundException("Categoria não encontrada!");
		}
		service.deletar(categoria);
		return new ResponseEntity<Categoria>(HttpStatus.OK);
	}
}
