package com.eduanlima.tools_challenge_api.model;

import lombok.Data;

@Data
public class FormaPagamento {
	private TipoFormaPagamento tipo;
	private Integer parcelas;
}
