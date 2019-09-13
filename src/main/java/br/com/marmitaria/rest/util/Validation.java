package br.com.marmitaria.rest.util;

import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.request.LoginRequest;
import br.com.marmitaria.rest.request.UsuarioRequest;

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
		validaUsuario(cliente);
		if(naoInformado(cliente.getEndereco())) {
			throw new DadosInvalidosException("Endereço não informado!");
		}
		
	}

	public static void validaUsuario(UsuarioRequest request) {
		if(naoInformado(request.getNome())) {
			throw new DadosInvalidosException("Nome não informado!");
		}
		if(naoInformado(request.getEmail())) {
			throw new DadosInvalidosException("Email não informado!");
		}
		if(naoInformado(request.getSenha())) {
			throw new DadosInvalidosException("Senha não informada!");
		}
	}

	public static boolean naoInformado(String valor) {
		return valor==null || valor.isEmpty();
	}
}
