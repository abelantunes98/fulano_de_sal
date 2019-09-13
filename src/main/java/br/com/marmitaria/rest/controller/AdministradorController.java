package br.com.marmitaria.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Administrador;
import br.com.marmitaria.persistence.service.AdministradorService;
import br.com.marmitaria.rest.exception.usuario.EmailJaCadastradoException;
import br.com.marmitaria.rest.request.UsuarioRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	private AdministradorService administradorService;
	
	@ApiOperation("Cria um administrador")
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<Administrador> create(@RequestBody UsuarioRequest usuarioRequest) {
		Validation.validaUsuario(usuarioRequest);

		Administrador administradorSave = administradorService.findByEmail(usuarioRequest.getEmail());

		if (administradorSave != null) {
			throw new EmailJaCadastradoException();
		}
		Administrador usuario = administradorService.salvar(new Administrador(usuarioRequest));


		return new ResponseEntity<Administrador>(usuario, HttpStatus.OK);
	}
}
