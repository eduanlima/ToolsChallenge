package com.eduanlima.tools_challenge_api.dto;

import com.eduanlima.tools_challenge_api.entities.enums.TipoFormaPagamento;
import com.eduanlima.tools_challenge_api.entities.model.FormaPagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoDTO {
	private TipoFormaPagamento tipo;
	private Integer parcelas;
	
	public FormaPagamentoDTO(FormaPagamento formaPagamento) {
		this.tipo = formaPagamento.getTipo();
		this.parcelas = formaPagamento.getParcelas();
	}
}
