package com.eduanlima.tools_challenge_api.model.entity;

import com.eduanlima.tools_challenge_api.model.enums.TipoFormaPagamento;

import lombok.Data;

@Data
public class FormaPagamento {
	private TipoFormaPagamento tipo;
	private Integer parcelas;
}
