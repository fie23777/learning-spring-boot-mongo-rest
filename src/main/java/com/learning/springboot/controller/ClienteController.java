package com.learning.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.model.Cliente;
import com.learning.springboot.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCliente() {
		System.out.println("ola mundo");
		return "deu certo";
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void createCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@RequestMapping(value = "/{id}")
	public Cliente read(@PathVariable String id) {
		return clienteRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void update(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(String id) {
		clienteRepository.delete(id);
	}
}
