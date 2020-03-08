package com.learning.springboot.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.learning.springboot.model.Contato;
import com.learning.springboot.repository.ContatoRepository;

@Service
public class ContatoService {

	
	private MongoTemplate mongoTemplate;
	public ContatoRepository contatoRepository;
	private MongoOperations mongoOperations;
	
	public ContatoService(MongoTemplate mongoTemplate, ContatoRepository contatoRepository,
			MongoOperations mongoOperations) {
		super();
		this.mongoTemplate = mongoTemplate;
		this.contatoRepository = contatoRepository;
		this.mongoOperations = mongoOperations;
	}
	
	public List<Contato> listarContatos(){
		return this.contatoRepository.findAll();
	}
	
	public Contato listarPorId(String id) {
		return this.contatoRepository.findOne(id);
	}
	
	public Contato cadastrarContato(Contato contato) {
		return this.contatoRepository.save(contato);
	}
	
	public void removerContato(String id) {
		this.contatoRepository.delete(id);
	}
	
}
