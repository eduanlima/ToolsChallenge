package com.eduanlima.tools_challenge_api.dto;

import com.eduanlima.tools_challenge_api.entities.model.Estorno;
import com.eduanlima.tools_challenge_api.entities.model.Pagamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO {
	private Long id;
	private String cartao;
	private DescricaoDTO descricao;
	private FormaPagamentoDTO formaPagamento;
	
	public TransacaoDTO(Pagamento pagamento) {
		this.id = pagamento.getId();
		this.cartao = pagamento.getCartao();
		this.descricao = new DescricaoDTO(pagamento.getDescricao());
		this.formaPagamento = new FormaPagamentoDTO(pagamento.getFormaPagamento());
	}
	
	public TransacaoDTO(Estorno estorno) {
		this.id = estorno.getId();
		this.cartao = estorno.getCartao();
		this.descricao = new DescricaoDTO(estorno.getDescricao());
		this.formaPagamento = new FormaPagamentoDTO(estorno.getFormaPagamento());
	}
}
