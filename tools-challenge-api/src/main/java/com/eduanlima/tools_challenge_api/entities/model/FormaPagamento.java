package com.eduanlima.tools_challenge_api.entities.model;

import com.eduanlima.tools_challenge_api.entities.enums.TipoFormaPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamento {
	private TipoFormaPagamento tipo;
	private Integer parcelas;
}
