package br.com.marmitaria.rest.exception.notFound;

public class RecuperacaoNaoEncontradaException extends NotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 269302312063373738L;
	
	public RecuperacaoNaoEncontradaException(){
		super("Não existe registros de pedidos de recuperação de senha.");
	}

}
