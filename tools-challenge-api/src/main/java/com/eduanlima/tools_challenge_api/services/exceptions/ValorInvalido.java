package com.eduanlima.tools_challenge_api.services.exceptions;

public class ValorInvalido extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ValorInvalido(String mensagem) {
		super(mensagem);
	}
}
