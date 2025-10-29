package com.eduanlima.tools_challenge_api.model.entity;

import java.math.BigDecimal;
import java.security.Timestamp;

import com.eduanlima.tools_challenge_api.model.enums.StatusTransacao;

import lombok.Data;

@Data
public class Descricao {
	private BigDecimal valor; 
	private Timestamp datahora;
	private String estabelecimento;
	private Long nsu;
	private Long codigoAutorizacao;
	private StatusTransacao status;
}
