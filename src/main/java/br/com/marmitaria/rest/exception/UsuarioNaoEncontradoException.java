package br.com.marmitaria.rest.exception;

import br.com.marmitaria.rest.exception.notFound.NotFoundException;

public class UsuarioNaoEncontradoException extends NotFoundException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7276658893915237999L;

	public UsuarioNaoEncontradoException() {
		super("O usuário não se encontra na base de dados do sistema.");
	}
}
