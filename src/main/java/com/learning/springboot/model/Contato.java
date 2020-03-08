package com.learning.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contato {
	
	@Id
	private String id;
	private String nome;
	private String email;
	private String telefone;
	private boolean ativo;
	
	public Contato() {
		super();
	}
	public Contato(String nome, String email, String telefone, boolean ativo) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.ativo = ativo;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

}
