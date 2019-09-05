package br.com.marmitaria.rest.controller;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.service.ClienteService;
import br.com.marmitaria.rest.exception.UsuarioNaoEncontradoException;
import br.com.marmitaria.rest.exception.usuario.EmailJaCadastradoException;
import br.com.marmitaria.rest.request.ClienteRequest;
import br.com.marmitaria.rest.util.Validation;
import br.com.marmitaria.util.Email;
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
		Cliente cliente = clienteService.salvar(new Cliente(clienteRequest));
		
		enviaEmail(cliente);
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@ApiOperation("Realiza a confirmação de cadastro do cliente")
	@GetMapping("confirmacao/{id}")
	@ResponseBody
	public ResponseEntity<String> confirmarCadastro(@PathVariable Long id){
		Cliente cliente = clienteService.findById(id);
		if(cliente != null) {
			cliente.setCadastroPendente(false);
			clienteService.salvar(cliente);
		}else {
			throw new UsuarioNaoEncontradoException();
		}
		String mensagem = String.format("Cliente %s confirmado com sucesso", cliente.getNome());
		return new ResponseEntity<String>(mensagem,HttpStatus.OK);
	}
	
	private void enviaEmail(Cliente cliente) {
		Thread mail = new Thread() {
			public void run() {	
				try {
					Email email = new Email(cliente);
					MimeMessage mail = mailSender.createMimeMessage();
		
					MimeMessageHelper helper = new MimeMessageHelper(mail);
					helper.setTo(cliente.getEmail());
					helper.setSubject(email.getSubject());
					helper.setText(email.getHtml(),true);
					mailSender.send(mail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		mail.start();
	}
	
}
