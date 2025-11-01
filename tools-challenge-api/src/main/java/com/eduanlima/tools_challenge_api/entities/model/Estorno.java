package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.interfaces.OperacaoCredito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Estorno extends Transacao implements OperacaoCredito {
	private String idPagamento;
	
	public Estorno(String id, String cartao, Descricao descricao, FormaPagamento formaPagamento, String idPagamento) {
		super(id, cartao, descricao, formaPagamento);
		this.idPagamento = idPagamento;
	}

	@Override
	public void adicionarValor(BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}
}
