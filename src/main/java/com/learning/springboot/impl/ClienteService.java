package com.learning.springboot.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.model.Cliente;
import com.learning.springboot.repository.ClienteRepository;

@Service
public class ClienteService implements com.learning.springboot.service.ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente listarPorId(String id) {
		// TODO Auto-generated method stub
		return this.clienteRepository.findOne(id);
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.clienteRepository.save(cliente);
	}

	@Override
	public void remover(String id) {
		this.clienteRepository.delete(id);

	}

}
