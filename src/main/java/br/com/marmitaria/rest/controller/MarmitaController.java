package br.com.marmitaria.rest.controller;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.persistence.model.Marmita;
import br.com.marmitaria.persistence.model.TipoMarmita;
import br.com.marmitaria.persistence.service.MarmitaService;
import br.com.marmitaria.rest.exception.DadosInvalidosException;
import br.com.marmitaria.rest.exception.notFound.NotFoundException;
import br.com.marmitaria.rest.request.MarmitaRequest;
import br.com.marmitaria.rest.util.Validation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/protegido/marmita")
public class MarmitaController {
	
	@Autowired
	private MarmitaService marmitaService;
	
	@ApiOperation("Cadastra marmita")
	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<Marmita> cadastra(@RequestBody MarmitaRequest marmitaRequest) {
		Validation.valida(marmitaRequest);
		TipoMarmita tipoMarmita = TipoMarmita.valueOf(TipoMarmita.class,marmitaRequest.getTipo());
		if(tipoMarmita==null) {
			throw new DadosInvalidosException("Tipo inválido");
		}
		Marmita marmita = new Marmita(marmitaRequest.getValor(),tipoMarmita,marmitaRequest.getDescricao());
		marmita = marmitaService.salvar(marmita);
		System.out.println("INSERT -> " + marmita);
		return new ResponseEntity<Marmita>(marmita,HttpStatus.OK);
	}
	
	@ApiOperation("Remove Marmita")
	@DeleteMapping("/remover")
	public ResponseEntity<Marmita> remove(@RequestParam("id") Long id) {
		Marmita marmita = marmitaService.findById(id);
		if(marmita==null) {
			throw new NotFoundException("Marmita não encontrada!");
		}
		System.out.println("DELETE -> " + marmita);
		marmitaService.deletar(marmita);
		return new ResponseEntity<Marmita>(HttpStatus.OK);
	}
	
	@ApiOperation("Retorna lista de marmitas")
	@GetMapping("/listar")
	@ResponseBody
	public ResponseEntity<List<Marmita>> list(){
		List<Marmita> marmitas = marmitaService.findAll();
		Collections.sort(marmitas);
		return new ResponseEntity<List<Marmita>>(marmitas,HttpStatus.OK);
	}
	
	@ApiOperation("Atualiza uma marmita")
	@PostMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Marmita> atualizar(@RequestBody Marmita marmitaRequest) {
		Validation.valida(marmitaRequest);
		Marmita marmita = marmitaService.findById(marmitaRequest.getIdMarmita());
		if(marmita==null) {
			throw new NotFoundException("Marmita não cadastrada!");
		}
		System.out.println("UPDADE BEFORE -> " + marmita);
		marmita = marmitaService.atualizar(marmitaRequest);
		System.out.println("UPDADE AFTER -> " + marmita);
		return new ResponseEntity<Marmita>(marmita,HttpStatus.OK);
	}

}
