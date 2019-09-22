package br.com.marmitaria.rest.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.request.CategoriaRequest;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.request.LoginRequest;
import br.com.marmitaria.rest.request.MarmitaRequest;
import br.com.marmitaria.rest.request.RecuperacaoRequest;
import br.com.marmitaria.rest.request.UsuarioRequest;

public abstract class Validation {
	
	private static final String EMAIL_PATTERN = 
	        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	public static void validaLogin(LoginRequest login) {
		
		validaEmail(login.getEmail());
		
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
		validaEmail(request.getEmail());
		
		if(naoInformado(request.getSenha())) {
			throw new DadosInvalidosException("Senha não informada!");
		}
	}

	public static boolean naoInformado(String valor) {
		return valor==null || valor.isEmpty();
	}

	public static void validaEmail(String email) {
		if(naoInformado(email)) {
			throw new DadosInvalidosException("Email não informado!");
		}
		Matcher matcher = pattern.matcher(email);
		
		if(!matcher.matches()) {
			throw new DadosInvalidosException("Email inválido!");
		}
	}

	public static void valida(MarmitaRequest marmitaRequest) {
		if(naoInformado(marmitaRequest.getValor())) {
			throw new DadosInvalidosException("Valor não informado!");
		}
		if(marmitaRequest.getTipo()==null) {
			throw new DadosInvalidosException("Tipo não informado!");
		}
	}

	private static boolean naoInformado(float valor) {
		return valor==0;
	}

	public static void valida(RecuperacaoRequest request) {
		if (naoInformado(request.getEmail())) {
			throw new DadosInvalidosException("Email não informado!");
		}

		if (naoInformado(request.getSenha())) {
			throw new DadosInvalidosException("Senha não informada!");
		}	
	}

	public static void valida(CategoriaRequest categoriaRequest) {
		if(naoInformado(categoriaRequest.getDescricao())) {
			throw new DadosInvalidosException("Descrição não informada!");
		}
	}
}
