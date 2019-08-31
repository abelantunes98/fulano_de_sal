package br.com.marmitaria.rest.exception.usuario;

public class SenhaInvalidaException extends UsuarioInvalidoException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6430284624171860574L;

	public SenhaInvalidaException() {
		super("Email cadastrado, mas senha não correspondente!");
	}

}
