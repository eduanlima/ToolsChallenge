package com.eduanlima.tools_challenge_api.model.interfaces;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.model.enums.TipoFormaPagamento;

public interface OperacaoDebito {
	BigDecimal consultarSaldoDisponivel();
	BigDecimal calcularJurosPorTipoFormaPagamento(TipoFormaPagamento tipo);
	BigDecimal debitarValor(BigDecimal valor);
}
