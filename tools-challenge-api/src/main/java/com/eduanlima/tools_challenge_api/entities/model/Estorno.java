package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.interfaces.OperacaoCredito;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Estorno extends Transacao implements OperacaoCredito {
	private Pagamento pagamento;
	
	public Estorno(String cartao, Descricao descricao, FormaPagamento formaPagamento, Pagamento pagamento) {
		super(cartao, descricao, formaPagamento);
		this.pagamento = pagamento;
	}

	@Override
	public void adicionarValor(BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}
}
