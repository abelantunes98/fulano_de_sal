package br.com.marmitaria.rest.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7276658893915237999L;

	public UsuarioNaoEncontradoException() {
		super("O usuário não se encontra na base de dados do sistema.");
	}
}
