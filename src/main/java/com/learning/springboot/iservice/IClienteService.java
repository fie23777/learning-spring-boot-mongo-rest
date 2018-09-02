package com.learning.springboot.service;

import java.util.List;

import com.learning.springboot.model.Cliente;
import com.learning.springboot.util.ClienteFilter;
import com.learning.springboot.util.ReturnGridCliente;

public interface ClienteService {
	
	List<Cliente> listarTodos(); 

	Cliente listarPorId(String id);
	
	Cliente cadastrar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	ReturnGridCliente findAll(ClienteFilter cliente);
	
	void remover(String id);
	
}
