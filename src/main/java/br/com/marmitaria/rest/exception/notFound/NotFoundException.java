package br.com.marmitaria.rest.exception.notFound;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3272101542765405879L;
	
	public NotFoundException(String mensagem) {
		super(mensagem);
	}

}
