package com.learning.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.learning.springboot.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	public Cliente findOneByNome(String nome);
}
