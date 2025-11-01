package com.eduanlima.tools_challenge_api.entities.base;

import java.util.UUID;

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
	
	public Transacao(String cartao, Descricao descricao, FormaPagamento formaPagamento) {
		this.cartao = cartao;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
		
		gerarId();
	}
	
	private final void gerarId() {
		if (id == null)
			id = String.valueOf(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
	}
}
