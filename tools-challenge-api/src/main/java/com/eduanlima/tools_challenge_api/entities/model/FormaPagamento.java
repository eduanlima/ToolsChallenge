package com.eduanlima.tools_challenge_api.entities.model;

import com.eduanlima.tools_challenge_api.entities.enums.TipoFormaPagamento;

import lombok.Data;

@Data
public class FormaPagamento {
	private TipoFormaPagamento tipo;
	private Integer parcelas;
}
