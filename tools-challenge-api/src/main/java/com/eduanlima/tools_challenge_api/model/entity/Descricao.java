package com.eduanlima.tools_challenge_api.model;

import java.math.BigDecimal;
import java.security.Timestamp;

import lombok.Data;

@Data
public class Descricao {
	private BigDecimal valor; 
	private Timestamp datahora;
	private String estabelecimento;
	private Long nsu;
	private Long codigoAutorizacao;
	private StatusTransacao status;
	private FormaPagamento formaPagamento;
}
