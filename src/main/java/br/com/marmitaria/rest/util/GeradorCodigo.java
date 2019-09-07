package br.com.marmitaria.rest.util;

import java.util.concurrent.ThreadLocalRandom;

public class GeradorCodigo {

	public static String gerarCodigoRecuperacaoSenha() {
		
		String retorno = "";
		for(int i = 0; i < 5; i++) {
			int tipo = ThreadLocalRandom.current().nextInt(0, 2);
			if(tipo==0) {
				retorno += getNumero();
			}else {
				int lower = ThreadLocalRandom.current().nextInt(0, 2);
				retorno += getLetra(lower);
			}
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		gerarCodigoRecuperacaoSenha();
	}
	
	private static String getNumero() {
		char value= (char) ThreadLocalRandom.current().nextInt(48, 58);
		return String.valueOf(value);
	}
	
	private static String getLetra(int aux) {
		char value = (char) ThreadLocalRandom.current().nextInt(aux==0?66:98, aux==0?91:123);
		return String.valueOf(value);
	}

}
