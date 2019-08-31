package br.com.marmitaria.rest.exception.usuario;

public class EmailNaoCadastradoException extends UsuarioInvalidoException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5524849540783422512L;

	public EmailNaoCadastradoException() {
		super("Email não cadastrado!");
	}

}
