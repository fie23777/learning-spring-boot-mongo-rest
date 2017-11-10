package com.learning.springboot.responsegeneric;

import java.util.List;

public class ResponseGeneric<T> {
	
	private T data;
	private List<String> erros;
	
	public ResponseGeneric(T data){
		this.data = data;
	}
	
	public ResponseGeneric(List<String> erros) {
		this.erros = erros;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	

}
