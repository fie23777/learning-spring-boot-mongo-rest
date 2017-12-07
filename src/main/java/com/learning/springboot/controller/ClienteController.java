package com.learning.springboot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.model.Cliente;
import com.learning.springboot.responsegeneric.ResponseGeneric;
import com.learning.springboot.service.ClienteService;
import com.learning.springboot.util.ClienteFilter;
import com.learning.springboot.util.ReturnGridCliente;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "/api/cliente")
public class ClienteController {

	@Autowired
	public ClienteService clienteService;
	
	
	@GetMapping
	public ResponseEntity<ResponseGeneric<List<Cliente>>> listarTodos(){
		return ResponseEntity.ok(new ResponseGeneric<List<Cliente>>( this.clienteService.listarTodos()));
	}
	
    @GetMapping("/panel")
    public ReturnGridCliente findAll(ClienteFilter clienteFilter) {
        return clienteService.findAll(clienteFilter);
    }

	@GetMapping(path="/{id}")
	public ResponseEntity<ResponseGeneric<Cliente>> listarPorId(@PathVariable(name="id") String id){
		return ResponseEntity.ok(new ResponseGeneric<Cliente>( this.clienteService.listarPorId(id)));
		
	}
	
	@PostMapping
	public ResponseEntity<ResponseGeneric<Cliente>> cadastrar(@RequestBody Cliente cliente, BindingResult result){
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro-> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseGeneric<Cliente>(erros));
		}
		return ResponseEntity.ok(new ResponseGeneric<Cliente>( this.clienteService.cadastrar(cliente)));
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<ResponseGeneric<Cliente>> cadastrar(@PathVariable(name="id") String id ,@RequestBody Cliente cliente){
		cliente.setId(id);
		return ResponseEntity.ok(new ResponseGeneric<Cliente>(this.clienteService.atualizar(cliente)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseGeneric<Integer>> deletar(@PathVariable(name="id") String id){
		this.clienteService.remover(id);
		return ResponseEntity.ok(new ResponseGeneric<Integer>(1));
	}
	
}
