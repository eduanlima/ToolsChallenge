package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.enums.TipoFormaPagamento;
import com.eduanlima.tools_challenge_api.entities.interfaces.OperacaoDebito;

public class Pagamento extends Transacao implements OperacaoDebito {
   
	public Pagamento(Long id, String cartao, Descricao descricao, FormaPagamento formaPagamento) {
		super(id, cartao, descricao, formaPagamento);
	}
	
	@Override
	public Integer gerarNsu(Integer ultimoNsu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer gerarCodigoAutorizacao(Integer ultimoCodigoAutorizacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal consultarSaldoDisponivel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public BigDecimal calcularJurosPorTipoFormaPagamento(BigDecimal valor, TipoFormaPagamento tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal debitarValor(BigDecimal total) {
		// TODO Auto-generated method stub
		return null;
	}
}
