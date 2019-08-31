package br.com.marmitaria.rest.exception.usuario;

public class UsuarioInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1369858863808562047L;
	
	public UsuarioInvalidoException(String msg) {
		super(msg);
	}

}
