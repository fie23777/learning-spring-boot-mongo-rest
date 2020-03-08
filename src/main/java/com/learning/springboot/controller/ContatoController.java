package com.learning.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.impl.ContatoService;
import com.learning.springboot.model.Contato;
import com.learning.springboot.responsegeneric.ResponseGeneric;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "/api/contato")
public class ContatoController {

	@Autowired
	public ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<ResponseGeneric<List<Contato>>> listarContatos(){
		return ResponseEntity.ok((new ResponseGeneric<List<Contato>>(this.contatoService.listarContatos())));
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<ResponseGeneric<Contato>> cadastrarContato(@RequestBody Contato contato, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(error -> erros.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseGeneric<Contato>(erros));
		}
		return ResponseEntity.ok(new ResponseGeneric<Contato>(this.contatoService.cadastrarContato(contato)));
	}
}
