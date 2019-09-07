package br.com.marmitaria.rest.util;

import br.com.marmitaria.persistence.model.Usuario;

public class Email {

	private Usuario usuario;

	public Email(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getHtmlConfirmarEmail() {
		String hostname = System.getProperty("api.hostname");
		String port = System.getProperty("api.port");
		String linkApi = String.format("http://%s:%s/api/cliente/confirmacao/%d",hostname,port,usuario.getId()); 
	
		String mail = String.format("<!doctype html>\n" + 
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

	public String getHtmlrecuperarSenha(String codigo) {
		String mail = String.format("<!doctype html>\n" + 
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
				"          <h5>Confirmação de Recuperação de senha</h5>\n" + 
				"          <p>Recebemos uma solicitação de recuperação de senha, seu código de verificação é: <h2><b>%s</b></h2>.</p>\n" + 
				"        </div>\n" + 
				"    </div>\n" + 
				"  </body>\n" + 
				"</html>", codigo);
		return mail;
	}

}
