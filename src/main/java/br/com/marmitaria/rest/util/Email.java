package br.com.marmitaria.rest.util;


import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.marmitaria.persistence.model.Usuario;

@Service
public class Email {

	private JavaMailSenderImpl mailSender;

	private Usuario usuario;

	public void setUsuario(Usuario usuario) {
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
		enviaEmail(getHtmlConfirmarEmail());
	}

//	private void enviaEmail(String html) throws EmailException, MalformedURLException {
//		System.out.println(">>>>>>>>>>>>>>>>>>> SEND EMAIL >>>>>>>>>>>>>>>>");
//		HtmlEmail email = new HtmlEmail();
//		email.setHostName(System.getProperty("mail.smtp.host"));
//		email.setAuthentication(System.getProperty("mail.username"), System.getProperty("mail.password"));
//		email.addTo(usuario.getEmail(),usuario.getNome());
//		email.setFrom(System.getProperty("mail.username"), "Fulano de Sal");
//		email.setSubject(getSubject());
//		  
//		email.setHtmlMsg(html);
//		email.setTLS(true);
//		email.setTextMsg("email de confirmação");
//		  
//		email.send();
//		System.out.println(">>>>>>>>>>>>>>>>>>> FINISH SEND >>>>>>>>>>>>>>>>");
//		
//	}

	private void enviaEmail(String html) {
		
		Thread mail = new Thread() {
			public void run() {
				try {
					mailSender = new JavaMailSenderImpl();
					System.out.println("<<<<<Send>>>>>");
					System.out.println(mailSender.getUsername());
					System.out.println(mailSender.getPassword());
					MimeMessage mail = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(mail);
					helper.setTo(usuario.getEmail());
					helper.setSubject(getSubject());
					helper.setText(html, true);
					
					mailSender.setHost("smtp.gmail.com");
				    mailSender.setPort(587);
				     
				    mailSender.setUsername("cursosufcg@gmail.com");
				    mailSender.setPassword("cursosufcg123");
				    
					Properties props = mailSender.getJavaMailProperties();
				    props.put("mail.transport.protocol", "smtp");
				    props.put("mail.smtp.auth", "true");
				    props.put("mail.smtp.starttls.enable", "true");
				    props.put("mail.debug", "true");
				    
					mailSender.send(mail);
					
					System.out.println("<<<<<Finish>>>>>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		mail.start();
	}

	public void enviaCodigoRecuperacao(String codigo) {

		enviaEmail(getHtmlrecuperarSenha(codigo));

	}
}
