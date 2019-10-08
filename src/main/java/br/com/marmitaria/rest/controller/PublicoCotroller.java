package br.com.marmitaria.rest.controller;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Cliente;
import br.com.marmitaria.persistence.model.Recuperacao;
import br.com.marmitaria.persistence.model.TipoUsuario;
import br.com.marmitaria.persistence.model.Usuario;
import br.com.marmitaria.persistence.service.ClienteService;
import br.com.marmitaria.persistence.service.RecuperacaoService;
import br.com.marmitaria.persistence.service.UsuarioService;
import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.exception.MailNotSendException;
import br.com.marmitaria.rest.exception.UsuarioNaoEncontradoException;
import br.com.marmitaria.rest.exception.notFound.RecuperacaoNaoEncontradaException;
import br.com.marmitaria.rest.exception.usuario.EmailJaCadastradoException;
import br.com.marmitaria.rest.exception.usuario.EmailNaoCadastradoException;
import br.com.marmitaria.rest.exception.usuario.SenhaInvalidaException;
import br.com.marmitaria.rest.login.TokenKey;
import br.com.marmitaria.rest.reponse.ClienteResponse;
import br.com.marmitaria.rest.reponse.UsuarioResponse;
import br.com.marmitaria.rest.request.ClienteRequest;
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

@Api
@RestController
@RequestMapping("/publico")
public class PublicoCotroller {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RecuperacaoService recuperacaoService;

	@ApiOperation("Cria um cliente")
	@PostMapping("/cliente/")
	@ResponseBody
	public ResponseEntity<Cliente> create(@RequestBody ClienteRequest clienteRequest) {
		Validation.validaCliente(clienteRequest);

		Usuario usuario = usuarioService.findByEmail(clienteRequest.getEmail());
		
		if (usuario != null) {
			throw new EmailJaCadastradoException();
		}
		
		Cliente cliente = clienteService.salvar(new Cliente(clienteRequest));

		enviaEmail(cliente);

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@GetMapping("/cliente/confirmacao")
	@ResponseBody
	public ResponseEntity<String> confirmarCadastro(@RequestParam("id") Long id) {
		Cliente cliente = clienteService.findById(id);
		if (cliente != null) {
			cliente.setCadastroPendente(false);
			clienteService.salvar(cliente);
		} else {
			throw new UsuarioNaoEncontradoException();
		}
		String mensagem = String.format("Email %s confirmado com sucesso.", cliente.getEmail());
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	}

	private void enviaEmail(Usuario usuario) {
		Email email = new Email(usuario);
		email.setUsuario(usuario);
		try {
		email.enviaConfirmaEmail();
		}catch (MailNotSendException e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation("Realiza Login")
	@PostMapping("/usuario/login")
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
				.setExpiration(new Date(System.currentTimeMillis() + Duration.ofDays(365).toMillis())).compact();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");

		ResponseEntity<UsuarioResponse> responseEntity = null;
		if (usuario.getTipo().equals(TipoUsuario.CLIENTE)) {
			responseEntity = new ResponseEntity<UsuarioResponse>(
					new ClienteResponse((Cliente) usuario, "Bearer " + token), HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<UsuarioResponse>(new UsuarioResponse(usuario, "Bearer " + token),
					HttpStatus.OK);
		}
		return responseEntity;
	}

	@ApiOperation("Realiza a solicitação de um código para a recuperação de email")
	@GetMapping("/usuario/solicitarRecuperacao")
	@ResponseBody
	public ResponseEntity<String> solicitarRecuperacao(@RequestParam("email") String emailRequest) {
		Validation.validaEmail(emailRequest);
		Usuario usuario = usuarioService.findByEmail(emailRequest);
		
		if (usuario == null) {
			throw new EmailNaoCadastradoException();
		}
		
		usuario.setCadastroPendente(true);
		usuario = usuarioService.atualizar(usuario);
		
		String codigo = GeradorCodigo.gerarCodigoRecuperacaoSenha();
		Recuperacao recuperacao = recuperacaoService.findByUsuario(usuario);
		if(recuperacao != null) {
			recuperacao.setCodigo(codigo);
			recuperacao.setUsuario(usuario);
			recuperacaoService.atualizar(recuperacao);
		}else {
			recuperacao = new Recuperacao.Builder().setUsuario(usuario).setDataCriacao(new Date())
				.setCodigo(codigo).build();
			recuperacaoService.salvar(recuperacao);
		}
		
		enviaEmail(usuario,codigo);
		return new ResponseEntity<String>("Email com código de verificação enviado", HttpStatus.OK);
	}
	
	@ApiOperation("Confirma o código de confirmação")
	@PostMapping("/usuario/confirmaCodigo")
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
	@PostMapping("/usuario/recuperarSenha")
	@ResponseBody
	public ResponseEntity<String> recuperarSenha(@RequestBody RecuperacaoRequest request) {
		Validation.valida(request);
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
		usuarioService.atualizar(usuario);
		
		recuperacaoService.deletar(recuperacao);
		return new ResponseEntity<String>("Senha alterada com sucesso",HttpStatus.OK);
	}
	
	@ApiOperation("Busca todos os usuários cadastrados no sistema")
	@ResponseBody
	@GetMapping("/usuario/listar")
	public ResponseEntity<List<Usuario>> usuariosCadastrados() {
		List<Usuario> usuarios = usuarioService.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	
	private void enviaEmail(Usuario usuario,String codigo) {
		Email email = new Email(usuario);
		email.setUsuario(usuario);
		try {
			email.enviaCodigoRecuperacao(codigo);
		}catch (MailNotSendException e) {
			e.printStackTrace();
			usuarioService.deletar(usuario);
		}
	}
	@ApiOperation("Realiza o reenvio do email de confirmação")
	@GetMapping("/usuario/reenviarEmail")
	@ResponseBody
	public ResponseEntity<String> reenviarEmailRecuperacao(@RequestParam("emailSender") String emailRequest) {
		Validation.validaEmail(emailRequest);
		Usuario usuario = usuarioService.findByEmail(emailRequest);
		enviaEmail(usuario);
		return new ResponseEntity<String>("Email enviado", HttpStatus.OK);
	}
	
	

}
