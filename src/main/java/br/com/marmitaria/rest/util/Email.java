package br.com.marmitaria.rest.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.marmitaria.persistence.model.Usuario;
import br.com.marmitaria.rest.exception.MailNotSendException;

public class Email {

	private Usuario usuario;
	
	public Email(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getHtmlConfirmarEmail() {
		String hostname = System.getProperty("api.hostname");
		String linkApi = String.format("http://%s/api/cliente/confirmacao?id=%d", hostname, usuario.getId());

		String mail = String.format("<!doctype html>\n" + "<html lang=\"pt-br\">\n" + "  <head>\n"
				+ "    <meta charset=\"utf-8\">\n" + "  </head>\n" + "  <body>\n" + "    <div>\n" + "        <div >\n"
				+ "          <h2>Fulano de sal</h2>\n" + "        </div>\n" + "        <div>\n"
				+ "          <h5>Confirmação de cadastro</h5>\n"
				+ "          <p>Recebemos uma solicitação de cadastro no sistema, clique no link abaixo para confirmar seu cadastro.</p>\n"
				+ "          <a href=\"%s\">Confirmar</a>\n" + "        </div>\n" + "    </div>\n" + "  </body>\n"
				+ "</html>", linkApi);
		return mail;
	}

	public String getSubject() {
		return "Confirmação de cadastro";
	}

	public String getHtmlrecuperarSenha(String codigo) {
		String mail = String.format("<!doctype html>\n" + "<html lang=\"pt-br\">\n" + "  <head>\n"
				+ "    <meta charset=\"utf-8\">\n" + "  </head>\n" + "  <body>\n" + "    <div>\n" + "        <div >\n"
				+ "          <h2>Fulano de sal</h2>\n" + "        </div>\n" + "        <div>\n"
				+ "          <h5>Confirmação de Recuperação de senha</h5>\n"
				+ "          <p>Recebemos uma solicitação de recuperação de senha, seu código de verificação é: <h2><b>%s</b></h2>.</p>\n"
				+ "        </div>\n" + "    </div>\n" + "  </body>\n" + "</html>", codigo);
		return mail;
	}

	public void enviaConfirmaEmail() {
		enviaEmail(getHtmlConfirmarEmail());
	}

	private void enviaEmail(String html) {
		Thread mailsend = new Thread() {
			public void run() {
				try {
					System.out.println("<<<<<Send>>>>>");
					SimpleEmail email = new SimpleEmail();
					email.setHostName(System.getProperty("mail.host"));
					email.setSmtpPort(Integer.parseInt(System.getProperty("mail.port")));
					email.setAuthentication(System.getProperty("mail.username"), System.getProperty("mail.password"));
					email.setStartTLSEnabled(true);
					email.setFrom(System.getProperty("mail.username"), "Fulano de Sal");
					email.setSubject(getSubject());
					email.setContent(html, "text/html");
					email.setCharset("utf-8");
					email.addTo(usuario.getEmail(), usuario.getNome());
					email.send();
					System.out.println("<<<<<Finish>>>>>");
				} catch (EmailException e) {
					throw new MailNotSendException(usuario.getEmail());
				}
			};
			
		};
		
		mailsend.start();

	}

	public void enviaCodigoRecuperacao(String codigo) {
		enviaEmail(getHtmlrecuperarSenha(codigo));

	}
}
