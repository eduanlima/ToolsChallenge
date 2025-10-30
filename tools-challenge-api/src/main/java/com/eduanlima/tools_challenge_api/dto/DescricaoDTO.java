package com.eduanlima.tools_challenge_api.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.eduanlima.tools_challenge_api.entities.enums.StatusTransacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescricaoDTO {
	private BigDecimal valor; 
	private Timestamp datahora;
	private String estabelecimento;
	private Long nsu;
	private Long codigoAutorizacao;
	private StatusTransacao status;
	
	public DescricaoDTO(Descricao descricao) {
		this.valor = descricao.getValor();
		this.datahora = descricao.getDatahora();
		this.estabelecimento = descricao.getEstabelecimento();
		this.nsu = descricao.getNsu();
		this.codigoAutorizacao = descricao.getCodigoAutorizacao();
		this.status = descricao.getStatus();
	}
}
