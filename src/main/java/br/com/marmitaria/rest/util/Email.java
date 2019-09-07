package br.com.marmitaria.rest.util;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.marmitaria.persistence.model.Usuario;

public class Email {

	private Usuario usuario;

	public Email(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getHtmlConfirmarEmail() {
		String hostname = System.getProperty("api.hostname");
		String linkApi = String.format("http://%s/api/cliente/confirmacao/%d", hostname, usuario.getId());

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
		try {
			enviaEmail(getHtmlConfirmarEmail());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	private void enviaEmail(String html) throws EmailException, MalformedURLException {
		System.out.println(">>>>>>>>>>>>>>>>>>> SEND EMAIL >>>>>>>>>>>>>>>>");
		HtmlEmail email = new HtmlEmail();
		email.setHostName(System.getProperty("mail.smtp.host"));
		email.setAuthentication(System.getProperty("mail.username"), System.getProperty("mail.password"));
		email.addTo(usuario.getEmail(),usuario.getNome());
		email.setFrom(System.getProperty("mail.username"), "Fulano de Sal");
		email.setSubject(getSubject());
		  
		email.setHtmlMsg(html);
		email.setTLS(true);
		email.setTextMsg("email de confirmação");
		  
		email.send();
		System.out.println(">>>>>>>>>>>>>>>>>>> FINISH SEND >>>>>>>>>>>>>>>>");
	}

	public void enviaCodigoRecuperacao(String codigo) {
		try {
			enviaEmail(getHtmlrecuperarSenha(codigo));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
	}
}
