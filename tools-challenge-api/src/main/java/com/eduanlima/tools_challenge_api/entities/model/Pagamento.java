package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.enums.TipoFormaPagamento;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pagamento extends Transacao {
	public Pagamento(String id, String cartao, Descricao descricao, FormaPagamento formaPagamento, BigDecimal taxa) {
		super(id, cartao, descricao, formaPagamento);
		aplicarJurosPorTipoFormaPagamento(taxa);
	}
	
	private final void aplicarJurosPorTipoFormaPagamento(BigDecimal taxa) {
		int parcelas = this.getFormaPagamento().getParcelas();

		TipoFormaPagamento tipo = this.getFormaPagamento().getTipo();
		if (tipo == TipoFormaPagamento.AVISTA || tipo == TipoFormaPagamento.PARCELADO_LOJA || tipo == TipoFormaPagamento.PARCELADO_EMISSOR && parcelas == 1)
			return;
	
		// calculo juros compostos com taxa de 10% ao mês
		BigDecimal valorAPagar = this.getDescricao().getValor();

		BigDecimal fator = BigDecimal.ONE.add(taxa);

		BigDecimal valorTotal = valorAPagar.multiply(fator.pow(parcelas));

		
		//return valorTotal.subtract(valorAPagar);
	}

}
