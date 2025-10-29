package com.eduanlima.tools_challenge_api.model.base;

import com.eduanlima.tools_challenge_api.model.entity.Descricao;
import com.eduanlima.tools_challenge_api.model.entity.FormaPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Transacao {
	@EqualsAndHashCode.Include
	private Long id;
	private Long cartao;
	private Descricao descricao;
	private FormaPagamento formaPagamento;
}
