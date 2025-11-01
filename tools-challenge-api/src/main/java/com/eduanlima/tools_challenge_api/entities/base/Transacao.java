package com.eduanlima.tools_challenge_api.entities.base;

import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.FormaPagamento;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Transacao {
	@Getter
	@EqualsAndHashCode.Include
	private String id;
	private String cartao;
	private Descricao descricao;
	private FormaPagamento formaPagamento;
	
	public Transacao(String id, String cartao, Descricao descricao, FormaPagamento formaPagamento) {
		this.id = id;
		this.cartao = cartao;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
	}
	
}
