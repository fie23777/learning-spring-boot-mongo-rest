package com.learning.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learning.springboot.model.Contato;

public interface ContatoRepository extends MongoRepository<Contato, String> {

}
