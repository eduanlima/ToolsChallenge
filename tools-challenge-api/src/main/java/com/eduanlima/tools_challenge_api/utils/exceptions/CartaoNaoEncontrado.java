package com.eduanlima.tools_challenge_api.utils.exceptions;

public class CartaoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CartaoNaoEncontrado(String mensagem) {
		super(mensagem);
	}
}
