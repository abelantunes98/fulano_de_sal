package br.com.marmitaria.rest.exception;

public class MailNotSendException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7933287788855071604L;
	private static final String MSG_BASE = "Não foi possível enviar e-mail para o endereço: ";
	
	public MailNotSendException(String email) {
		super(String.format("%s %s.", MSG_BASE,email));
	}
}
