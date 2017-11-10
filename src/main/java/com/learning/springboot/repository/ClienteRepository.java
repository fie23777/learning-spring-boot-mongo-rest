package com.learning.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learning.springboot.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
}
