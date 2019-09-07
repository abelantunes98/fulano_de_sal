package br.com.marmitaria.rest.controller;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.model.Recuperacao;
import br.com.marmitaria.persistence.model.Tipo;
import br.com.marmitaria.persistence.model.Usuario;
import br.com.marmitaria.persistence.service.RecuperacaoService;
import br.com.marmitaria.persistence.service.UsuarioService;
import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.exception.UsuarioNaoEncontradoException;
import br.com.marmitaria.rest.exception.notFound.RecuperacaoNaoEncontradaException;
import br.com.marmitaria.rest.exception.usuario.EmailNaoCadastradoException;
import br.com.marmitaria.rest.exception.usuario.SenhaInvalidaException;
import br.com.marmitaria.rest.login.TokenKey;
import br.com.marmitaria.rest.reponse.ClienteResponse;
import br.com.marmitaria.rest.reponse.UsuarioResponse;
import br.com.marmitaria.rest.request.ConfirmacaoDeCodigoRequest;
import br.com.marmitaria.rest.request.LoginRequest;
import br.com.marmitaria.rest.request.RecuperacaoRequest;
import br.com.marmitaria.rest.util.Email;
import br.com.marmitaria.rest.util.GeradorCodigo;
import br.com.marmitaria.rest.util.Validation;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Responsável por atender requisições genericas de usuários")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RecuperacaoService recuperacaoService;

	@Autowired
	private JavaMailSender mailSender;

	@ApiOperation("Realiza Login")
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<UsuarioResponse> login(@RequestBody LoginRequest login) {
		Validation.validaLogin(login);
		Usuario usuario = this.usuarioService.findByEmail(login.getEmail());

		if (usuario == null)
			throw new EmailNaoCadastradoException();
		if (!usuario.getSenha().equals(login.getSenha()))
			throw new SenhaInvalidaException();

		String token = Jwts.builder().setSubject(usuario.getEmail())
				.signWith(SignatureAlgorithm.HS512, TokenKey.TOKEN_KEY.getValue())
				.setExpiration(new Date(System.currentTimeMillis() + 1800000)).compact();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");

		ResponseEntity<UsuarioResponse> responseEntity = null;
		if (usuario.getTipo().equals(Tipo.CLIENTE)) {
			responseEntity = new ResponseEntity<UsuarioResponse>(
					new ClienteResponse((Cliente) usuario, "Bearer " + token), HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<UsuarioResponse>(new UsuarioResponse(usuario, "Bearer " + token),
					HttpStatus.OK);
		}
		return responseEntity;
	}

	@ApiOperation("Realiza a solicitação de um código para a recuperação de email")
	@GetMapping("/solicitarRecuperacao")
	@ResponseBody
	public ResponseEntity<String> solicitarRecuperacao(@RequestParam("email") String emailRequest) {

		if (Validation.naoInformado(emailRequest)) {
			throw new DadosInvalidosException("Email não informado");
		}

		Usuario usuario = usuarioService.findByEmail(emailRequest);
		
		if (usuario == null) {
			throw new EmailNaoCadastradoException();
		}
		
		usuario.setCadastroPendente(true);
		usuario = usuarioService.update(usuario);
		
		String codigo = GeradorCodigo.gerarCodigoRecuperacaoSenha();
		Recuperacao recuperacao = recuperacaoService.findByUsuario(usuario);
		if(recuperacao != null) {
			recuperacao.setCodigo(codigo);
			recuperacao.setUsuario(usuario);
			recuperacaoService.update(recuperacao);
		}else {
			recuperacao = new Recuperacao.Builder().setUsuario(usuario).setDataCriacao(new Date())
				.setCodigo(codigo).build();
			recuperacaoService.create(recuperacao);
		}

		enviaEmailCodigoRecuperacao(usuario, codigo);

		return new ResponseEntity<String>("Email com código de verificação enviado", HttpStatus.OK);
	}
	
	@ApiOperation("Confirma o código de confirmação")
	@PostMapping("/confirmaCodigo")
	@ResponseBody
	public ResponseEntity<Boolean> confirmaCodigoRecuperacao(@RequestBody ConfirmacaoDeCodigoRequest request) {
		if (Validation.naoInformado(request.getEmail())) {
			throw new DadosInvalidosException("Email não informado");
		}
		if (Validation.naoInformado(request.getCodigo())) {
			throw new DadosInvalidosException("Codigo não informado");
		}
		
		Usuario usuario = usuarioService.findByEmail(request.getEmail());
		
		if(usuario==null) {
			throw new UsuarioNaoEncontradoException();
		}
		
		if (!usuario.isCadastroPendente()) {
			throw new DadosInvalidosException("Usuário não solicitou recuperação de senha.");
		}
		
		Recuperacao recuperacao = recuperacaoService.findByUsuario(usuario);

		if (recuperacao == null) {
			throw new RecuperacaoNaoEncontradaException();
		}
		boolean retorno = true;
		if(!request.getCodigo().equals(recuperacao.getCodigo())){
			retorno = false;
		}
		
		return new ResponseEntity<Boolean>(retorno,HttpStatus.OK);
	}

	@ApiOperation("Recuperação de Senha")
	@PostMapping("/recuperarSenha")
	@ResponseBody
	public ResponseEntity<String> recuperarSenha(@RequestBody RecuperacaoRequest request) {

		if (Validation.naoInformado(request.getEmail())) {
			throw new DadosInvalidosException("Email não informado");
		}

		if (Validation.naoInformado(request.getSenha())) {
			throw new DadosInvalidosException("Senha não informada");
		}

		Usuario usuario = usuarioService.findByEmail(request.getEmail());
		
		if(usuario==null) {
			throw new UsuarioNaoEncontradoException();
		}
		
		if (!usuario.isCadastroPendente()) {
			throw new DadosInvalidosException("Usuário não solicitou recuperação de senha.");
		}
		
		Recuperacao recuperacao = recuperacaoService.findByUsuario(usuario);

		if (recuperacao == null) {
			throw new RecuperacaoNaoEncontradaException();
		}

		usuario.setSenha(request.getSenha());
		usuario.setCadastroPendente(false);
		usuarioService.update(usuario);
		
		recuperacaoService.delete(recuperacao);
		return new ResponseEntity<String>("Senha alterada com sucesso",HttpStatus.OK);
	}

	private void enviaEmailCodigoRecuperacao(Usuario usuario, String codigo) {
		Thread mail = new Thread() {
			public void run() {
				try {
					Email email = new Email(usuario);
					MimeMessage mail = mailSender.createMimeMessage();

					MimeMessageHelper helper = new MimeMessageHelper(mail);
					helper.setTo(usuario.getEmail());
					helper.setSubject(email.getSubject());
					helper.setText(email.getHtmlrecuperarSenha(codigo), true);
					mailSender.send(mail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		mail.start();
	}

}