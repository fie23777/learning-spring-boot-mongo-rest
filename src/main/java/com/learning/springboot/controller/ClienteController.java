package com.learning.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public  List<Cliente> getAllCliente() {
		Sort sortByNome = new Sort(Sort.Direction.ASC, "email");
		return clienteRepository.findAll(sortByNome);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void createCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@RequestMapping(value = "cliente/{id}")
	public Cliente read(@PathVariable String id) {
		return clienteRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE )
	public void update(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@DeleteMapping(value = "/cliente/{id}")
	public void delete(@PathVariable ("id") String id) {
		clienteRepository.delete(id);
	}
}
