package com.learning.springboot.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {

	
	@Id
	private String id;
	
	@NotEmpty(message="O nome não pode ser vazio")
	private String nome;
	
	@NotEmpty(message="O email não pode ser vazio")
	@Email(message="Email inválido")
	private String email;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
