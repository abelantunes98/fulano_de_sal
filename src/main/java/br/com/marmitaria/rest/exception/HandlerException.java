package br.com.marmitaria.rest.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.exception.usuario.UsuarioInvalidoException;

@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler(DadosInvalidosException.class)
	public ResponseEntity<CustomError> dadosInvalidos(DadosInvalidosException e, WebRequest request){
		return dispache(request, e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UsuarioInvalidoException.class)
	public ResponseEntity<CustomError> usuarioInvalido(UsuarioInvalidoException e, WebRequest request) {
		return dispache(request,e,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomError> notFound(NotFoundException e, WebRequest request){
		return dispache(request, e, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TokenException.class)
	public ResponseEntity<CustomError> tokenInvalido(TokenException e, WebRequest request){
		return dispache(request, e, HttpStatus.UNAUTHORIZED);
	}

	private ResponseEntity<CustomError> dispache(WebRequest request, RuntimeException e, HttpStatus status) {
		CustomError customRestError = new CustomError(new Date(),e.getMessage());
		request.getDescription(false);
		return new ResponseEntity<CustomError>(customRestError,status);
	}
}
