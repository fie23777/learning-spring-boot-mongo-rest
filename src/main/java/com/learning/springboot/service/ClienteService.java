package com.learning.springboot.service;

import java.util.List;

import com.learning.springboot.impl.ClienteFilter;
import com.learning.springboot.impl.ReturnGridCliente;
import com.learning.springboot.model.Cliente;

public interface ClienteService {
	
	List<Cliente> listarTodos(); 

	Cliente listarPorId(String id);
	
	Cliente cadastrar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	ReturnGridCliente findAll(ClienteFilter cliente);
	
	void remover(String id);
	
}
