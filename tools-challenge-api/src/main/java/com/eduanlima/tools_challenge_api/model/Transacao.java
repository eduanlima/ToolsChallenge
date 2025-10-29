package com.eduanlima.tools_challenge_api.model;

import lombok.Data;

@Data
public abstract class Transacao {
	private Long id;
	private Long cartao;
	private Descricao descricao;

	public abstract void processar();
}
