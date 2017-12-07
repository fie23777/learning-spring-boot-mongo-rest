package com.learning.springboot.util;

import java.util.ArrayList;
import java.util.List;

import com.learning.springboot.model.Cliente;

public class ReturnGridCliente {

    private List<Cliente> conteudo = new ArrayList<>();

	public List<Cliente> getConteudo() {
		return conteudo;
	}

	public void setConteudo(List<Cliente> conteudo) {
		this.conteudo = conteudo;
	}
	
}
