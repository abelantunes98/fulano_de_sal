package br.com.marmitaria.rest.exception.usuario;

public class EmailJaCadastradoException extends UsuarioInvalidoException{

	public EmailJaCadastradoException() {
		super("O email já esta em uso.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5041010979796488855L;

}
