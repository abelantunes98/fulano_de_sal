package br.com.marmitaria.rest.exception.usuario;

import br.com.marmitaria.rest.exception.notFound.NotFoundException;

public class EmailNaoCadastradoException extends NotFoundException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5524849540783422512L;

	public EmailNaoCadastradoException() {
		super("Email não cadastrado!");
	}

}
