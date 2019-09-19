package br.com.marmitaria.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.service.RecuperacaoService;
import br.com.marmitaria.persistence.service.UsuarioService;
import io.swagger.annotations.Api;

@Api("Responsável por atender requisições genericas de usuários")
@RestController
@RequestMapping("/usuario")
public class UsuarioController{

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RecuperacaoService recuperacaoService;
	

	
	
	

}
