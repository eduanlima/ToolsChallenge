package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.enums.StatusTransacao;
import com.eduanlima.tools_challenge_api.entities.enums.TipoFormaPagamento;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Pagamento extends Transacao {
	public Pagamento(String id, String cartao, Descricao descricao, FormaPagamento formaPagamento) {
		super(id, cartao, descricao, formaPagamento);
	}
	
	private boolean validarValor() {
		return this.getDescricao().getValor().compareTo(BigDecimal.ZERO) > 0;
	}
	
	private boolean validarPagamento(BigDecimal limiteDisponivelCartao) {	
		return limiteDisponivelCartao.compareTo(this.getDescricao().getValor()) >= 0;
	}
	
	public void processarPagamento(BigDecimal limiteDisponivelCartao, BigDecimal taxaJuros) {
		Descricao descricao = this.getDescricao();
		int parcelas = this.getFormaPagamento().getParcelas();
		
		if (!validarValor()) 
			System.out.println("Lançar exceção");
		
		if (this.getFormaPagamento().getTipo().equals(TipoFormaPagamento.PARCELADO_EMISSOR) && parcelas > 1) {
			BigDecimal valorAPagar = descricao.getValor();
			BigDecimal fator = BigDecimal.ONE.add(taxaJuros);
			descricao.setValor(valorAPagar.multiply(fator.pow(parcelas)));
		}
	
		if (validarPagamento(limiteDisponivelCartao))
			descricao.setStatus(StatusTransacao.AUTORIZADO);
		else
			descricao.setStatus(StatusTransacao.NEGADO);
	}
}
