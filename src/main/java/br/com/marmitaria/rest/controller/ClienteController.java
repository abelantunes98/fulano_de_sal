package br.com.marmitaria.rest.controller;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.service.ClienteService;
import br.com.marmitaria.rest.exception.usuario.EmailJaCadastradoException;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@ApiOperation("Cria um cliente")
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<Cliente> create(@RequestBody ClienteRequest clienteRequest){
		Validation.validaCliente(clienteRequest);
		
		Cliente clienteSave = clienteService.findByEmail(clienteRequest.getEmail());
		
		if(clienteSave != null) {
			throw new EmailJaCadastradoException();
		}
		Cliente cliente = clienteService.create(new Cliente(clienteRequest));
		
		enviaEmail(cliente);
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	private void enviaEmail(Cliente cliente) {
		Thread mail = new Thread() {
			public void run() {	
				try {
					MimeMessage mail = mailSender.createMimeMessage();
		
					MimeMessageHelper helper = new MimeMessageHelper(mail);
					helper.setTo(cliente.getEmail());
					helper.setSubject("Comfirmação de cadastro");
					helper.setText(gerarHtmlEmail(cliente));
					mailSender.send(mail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private String gerarHtmlEmail(Cliente cliente) {
				String mail = "<!doctype html>\n" + 
						"<html lang=\"pt-br\">\n" + 
						"  <head>\n" + 
						"    <!-- Required meta tags -->\n" + 
						"    <meta charset=\"utf-8\">\n" + 
						"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" + 
						"\n" + 
						"    <!-- Bootstrap CSS -->\n" + 
						"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" + 
						"  </head>\n" + 
						"  <body>\n" + 
						"    <div class=\"card\">\n" + 
						"        <div class=\"card-header\">\n" + 
						"            <h2>Fulano de Sal</h2>\n" + 
						"        </div>\n" + 
						"        <div class=\"card-body\">\n" + 
						"          <h5 class=\"card-title\">Confirmação de Cadastro</h5>\n" + 
						"          <p class=\"card-text\">Recebemos um pedido de cadastro e para mais segurança confirme seu cadastro abaixo.</p>\n" + 
						"          <a href=\"#\" class=\"btn btn-primary\">Confirmar</a>\n" + 
						"        </div>\n" + 
						"      </div>\n" + 
						"\n" + 
						"    <!-- Optional JavaScript -->\n" + 
						"    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" + 
						"    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" + 
						"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n" + 
						"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n" + 
						"  </body>\n" + 
						"</html>";
				return mail;
			}
		};
		
		mail.start();
	}
	
}
