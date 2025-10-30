package com.eduanlima.tools_challenge_api.entities.base;

import java.util.UUID;

import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.FormaPagamento;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Transacao {
	@EqualsAndHashCode.Include
	private Long id;
	private String cartao;
	private Descricao descricao;
	private FormaPagamento formaPagamento;
	
	public Transacao(Long id, String cartao, Descricao descricao, FormaPagamento formaPagamento) {
		this.id = id;
		this.cartao = cartao;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
		
		gerarId();
	}
	
	private final void gerarId() {
		if (id == null)
			id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}
	
	public Integer gerarNsu(Integer ultimoNsu) {
		return ultimoNsu + 1;
	}
	
	public Integer gerarCodigoAutorizacao(Integer ultimoCodigoAutorizacao) {
		return ultimoCodigoAutorizacao + 1;
	}
}
