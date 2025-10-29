package com.eduanlima.tools_challenge_api.model.entity;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.model.base.Transacao;
import com.eduanlima.tools_challenge_api.model.interfaces.OperacaoCredito;

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
	
	public Estorno(Long id, Long cartao, Descricao descricao, FormaPagamento formaPagamento, Pagamento pagamento) {
		super(id, cartao, descricao, formaPagamento);
		this.pagamento = pagamento;
	}

	@Override
	public void adicionarValor(BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}	
}
