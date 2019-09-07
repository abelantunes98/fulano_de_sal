package br.com.marmitaria.rest.util;

import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.request.LoginRequest;

public abstract class Validation {
	
	public static void validaLogin(LoginRequest login) {
		
		if(naoInformado(login.getEmail())) {
			throw new DadosInvalidosException("Email não informado!");
		}
		
		if(naoInformado(login.getSenha())) {
			throw new DadosInvalidosException("Senha não informada!");
		}
		
	}

	public static void validaCliente(ClienteRequest cliente) {
		if(naoInformado(cliente.getNome())) {
			throw new DadosInvalidosException("Nome não informado!");
		}
		if(naoInformado(cliente.getEmail())) {
			throw new DadosInvalidosException("Email não informado!");
		}
		if(naoInformado(cliente.getSenha())) {
			throw new DadosInvalidosException("Senha não informada!");
		}
		if(naoInformado(cliente.getEndereco())) {
			throw new DadosInvalidosException("Endereço não informado!");
		}
		
	}

	public static boolean naoInformado(String valor) {
		return valor==null || valor.isEmpty();
	}
}
