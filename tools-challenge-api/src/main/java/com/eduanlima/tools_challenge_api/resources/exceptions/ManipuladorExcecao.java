package com.eduanlima.tools_challenge_api.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eduanlima.tools_challenge_api.services.exceptions.RecursoNaoEncontrado;
import com.eduanlima.tools_challenge_api.services.exceptions.ValorInvalido;
import com.eduanlima.tools_challenge_api.utils.exceptions.CartaoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorExcecao {
	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> lancarRecursoNaoEncontrado(RecursoNaoEncontrado e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setDataHora(Instant.now());
		erro.setStatus(status.value());
		erro.setErro("Recurso não encontrado.");
		erro.setMensagem(e.getMessage());
		erro.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(ValorInvalido.class)
	public ResponseEntity<ErroPadrao> lancarValorInvalido(ValorInvalido e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setDataHora(Instant.now());
		erro.setStatus(status.value());
		erro.setErro("Valor invalido.");
		erro.setMensagem(e.getMessage());
		erro.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(CartaoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> lancarCartaoNaoEncontrado(CartaoNaoEncontrado e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erro = new ErroPadrao();
		erro.setDataHora(Instant.now());
		erro.setStatus(status.value());
		erro.setErro("Cartão não encontrado.");
		erro.setMensagem(e.getMessage());
		erro.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
