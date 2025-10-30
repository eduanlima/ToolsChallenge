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
	
	public Estorno(Long id, String cartao, Descricao descricao, FormaPagamento formaPagamento, Pagamento pagamento) {
		super(id, cartao, descricao, formaPagamento);
		this.pagamento = pagamento;
	}

	@Override
	public void adicionarValor(BigDecimal valor) {
		// TODO Auto-generated method stub
		
	}
}
