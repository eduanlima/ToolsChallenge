package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;
import java.util.UUID;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.enums.StatusTransacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Estorno extends Transacao {
	private String idPagamento;
	
	public Estorno() {
		gerarId();
	}
	
	private final void gerarId() {
		if (this.getId() == null)
			this.setId(String.valueOf(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE));
	}
	
	public BigDecimal valorCreditar() {
		if (this.getDescricao().getStatus().equals(StatusTransacao.NEGADO))
			return new BigDecimal("0");
			
		return this.getDescricao().getValor();
	}
	
	public void processarEstorno(StatusTransacao statusTransacaoPagamento) {
		if (statusTransacaoPagamento.equals(StatusTransacao.NEGADO)) 
			this.getDescricao().setStatus(StatusTransacao.NEGADO);
		else
			this.getDescricao().setStatus(StatusTransacao.CANCELADO);
	}
}
