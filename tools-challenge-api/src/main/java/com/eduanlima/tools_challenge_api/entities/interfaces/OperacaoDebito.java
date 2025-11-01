package com.eduanlima.tools_challenge_api.entities.interfaces;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.entities.enums.TipoFormaPagamento;

public interface OperacaoDebito {
	void aplicarJurosPorTipoFormaPagamento(BigDecimal taxa);
}
