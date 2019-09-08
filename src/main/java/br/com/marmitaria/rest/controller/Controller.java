package br.com.marmitaria.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.marmitaria.rest.util.Email;

@RestController
public class Controller {
	
	@Autowired
	protected Email email;

}
