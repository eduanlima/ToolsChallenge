package com.eduanlima.tools_challenge_api.model.entity;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.model.base.Transacao;
import com.eduanlima.tools_challenge_api.model.enums.TipoFormaPagamento;
import com.eduanlima.tools_challenge_api.model.interfaces.OperacaoDebito;

public class Pagamento extends Transacao implements OperacaoDebito {

	public Pagamento(Long id, Long cartao, Descricao descricao, FormaPagamento formaPagamento) {
		super(id, cartao, descricao, formaPagamento);
	}

	@Override
	public BigDecimal calcularJurosPorTipoFormaPagamento(TipoFormaPagamento tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal consultarSaldoDisponivel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal debitarValor(BigDecimal valor) {
		// TODO Auto-generated method stub
		return null;
	}

}
