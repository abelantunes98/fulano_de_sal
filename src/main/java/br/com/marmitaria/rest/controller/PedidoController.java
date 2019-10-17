package br.com.marmitaria.rest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.Pedido;
import br.com.marmitaria.persistence.model.Produto;
import br.com.marmitaria.persistence.service.ClienteService;
import br.com.marmitaria.persistence.service.MarmitaService;
import br.com.marmitaria.persistence.service.PedidoService;
import br.com.marmitaria.persistence.service.ProdutoService;
import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.reponse.PedidoResponse;
import br.com.marmitaria.rest.reponse.PedidosResponse;
import br.com.marmitaria.rest.request.PedidoRequest;
import br.com.marmitaria.rest.util.ComparatorPedido;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/protegido/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService  produtoService;
	
	@Autowired
	private MarmitaService marmitaService;
	
	@ApiOperation("Cadastra um pedido")
	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<PedidoResponse> cadastrar(@RequestBody PedidoRequest pedidoRequest){
		Validation.valida(pedidoRequest);
		Pedido pedido = new Pedido();
		pedido.setConfirmado(false);
		pedido.setTipoPagamento(pedidoRequest.getTipoPagamento());
		pedido.setObsvacoes(pedidoRequest.getObservacoes());
		
		Cliente cliente = clienteService.findByEmail(pedidoRequest.getEmail());
		if(cliente == null) throw new NotFoundException("Cliente não encontrado!");
		pedido.setCliente(cliente);
		
		Marmita marmita = marmitaService.findById(pedidoRequest.getIdMarmita());
		if(marmita==null)throw new NotFoundException("Marmita não cadastrada!");
		pedido.setMarmita(marmita);
		
		pedido.setProdutos(new ArrayList<>());
		for(Long idProduto: pedidoRequest.getIdProdutos()){
			Produto produto = produtoService.findById(idProduto);
			if(produto==null)throw new NotFoundException("O pedido contém produtos não cadastrados!");
			pedido.getProdutos().add(produto);
		}
		
		pedido = pedidoService.salvar(pedido);
		PedidoResponse pedidoResponse = new PedidoResponse(pedido);
		return new ResponseEntity<>(pedidoResponse,HttpStatus.OK);
	}
	
	@ApiOperation("Retorna todos os pedidos do dia, os confirmados vem, sempre no inicio.")
	@ResponseBody
	@GetMapping("/listarAdmin")
	public ResponseEntity<PedidosResponse> listar(){
		List<Pedido> pedidos = pedidoService.findAll();
		ComparatorPedido comparatorPedido =new ComparatorPedido();
		Collections.sort(pedidos,comparatorPedido);
		PedidosResponse pedidosResponse = new PedidosResponse(pedidos);
		return new ResponseEntity<PedidosResponse>(pedidosResponse,HttpStatus.OK);
	} 
	
	@ApiOperation("Confirmar Pedido")
	@ResponseBody
	@GetMapping("/confirmar")
	public ResponseEntity<PedidoResponse> confirmar(@RequestParam("id") Long id){
		if(Validation.naoInformado(id))throw new DadosInvalidosException("Pedido não informado!");
		Pedido pedido = pedidoService.findById(id);
		if(pedido==null) throw new NotFoundException("Pedido não cadastrado!");
		
		pedido.setConfirmado(true);
		pedido = pedidoService.atualizar(pedido);
		PedidoResponse pedidoResponse = new PedidoResponse(pedido);
		return new ResponseEntity<PedidoResponse>(pedidoResponse,HttpStatus.OK);
	}
	
	@ApiOperation("Lista os pedidos de um determinado cliente")
	@ResponseBody
	@GetMapping("/listarCliente")
	public ResponseEntity<PedidosResponse> listarPorCliente(@RequestParam("email") String email){
		Validation.validaEmail(email);
		Cliente cliente = clienteService.findByEmail(email);
		if(cliente==null) throw new NotFoundException("Cliente não cadastrado!");
		List<Pedido> pedidos = pedidoService.findByCliente(cliente);
		Collections.sort(pedidos, new ComparatorPedido());
		PedidosResponse pedidosResponse = new PedidosResponse(pedidos);
		return new ResponseEntity<PedidosResponse>(pedidosResponse,HttpStatus.OK);
	}
	
	@ApiOperation("Apagar pedidos confirmados do dia")
	@GetMapping("/limparDia")
	public ResponseEntity<Pedido> apagarPedidos(){
		List<Pedido> pedidos = pedidoService.findAll();
		for(Pedido pedido : pedidos){
			if(pedido.getConfirmado())pedidoService.deletar(pedido);
		}
		return new ResponseEntity<Pedido>(HttpStatus.OK);
	}
	
}


