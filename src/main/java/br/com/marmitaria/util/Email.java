package br.com.marmitaria.util;

import br.com.marmitaria.persistence.model.Cliente;

public class Email {

	private Cliente cliente;

	public Email(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getHtml() {
		String linkApi = String.format("http://fulano-de-sal.herokuapp.com/api/cliente/confirmacao/%d",cliente.getId()); 
	
		String mail = String.format("<<!doctype html>\n" + 
				"<html lang=\"pt-br\">\n" + 
				"  <head>\n" + 
				"    <meta charset=\"utf-8\">\n" + 
				"  </head>\n" + 
				"  <body>\n" + 
				"    <div>\n" + 
				"        <div >\n" + 
				"          <h2>Fulano de sal</h2>\n" + 
				"        </div>\n" + 
				"        <div>\n" + 
				"          <h5>Confirmação de cadastro</h5>\n" + 
				"          <p>Recebemos uma solicitação de cadastro no sistema, clique no link abaixo para confirmar seu cadastro.</p>\n" + 
				"          <a href=\"%s\">Confirmar</a>\n" + 
				"        </div>\n" + 
				"    </div>\n" + 
				"  </body>\n" + 
				"</html>", linkApi);
		return mail;
	}

	public String getSubject() {
		return "Confirmação de cadastro";
	}

}
