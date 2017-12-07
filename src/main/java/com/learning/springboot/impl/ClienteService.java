package com.learning.springboot.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.learning.springboot.model.Cliente;
import com.learning.springboot.repository.ClienteRepository;

@Service
public class ClienteService implements com.learning.springboot.service.ClienteService {
	
	private MongoTemplate mongoTemplate;
	public ClienteRepository clienteRepository;
	private MongoOperations mongoOperations;
	
	
	@Autowired
	public ClienteService(ClienteRepository repository, MongoOperations mongoOperations,
			MongoTemplate mongoTemplate) {
		this.clienteRepository = repository;
		this.mongoOperations = mongoOperations;
		this.mongoTemplate = mongoTemplate;
	}
	
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
	//**************************************************************************************
	public ReturnGridCliente findAll(ClienteFilter filter) {
		
		ReturnGridCliente result = new ReturnGridCliente();
	
	    Criteria criterias = new Criteria();
	
		   if (filter.getNome() != null && !filter.getNome().isEmpty()) {
			   criterias.where("nome").regex(filter.getNome());
		   }
	
	Query query = new Query(criterias);
	

	
	   List<Cliente> cliente = mongoTemplate.find(query, Cliente.class);
	   result.setConteudo(cliente);
	   
	return result;
	
	}

}
