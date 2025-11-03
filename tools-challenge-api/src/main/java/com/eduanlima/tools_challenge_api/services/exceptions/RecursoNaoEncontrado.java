package com.eduanlima.tools_challenge_api.services.exceptions;

public class RecursoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontrado(String mensagem) {
		super(mensagem);
	}
}
