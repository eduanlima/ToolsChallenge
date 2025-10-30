package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.eduanlima.tools_challenge_api.entities.enums.StatusTransacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Descricao {
	private BigDecimal valor; 
	private Timestamp datahora;
	private String estabelecimento;
	private Long nsu;
	private Long codigoAutorizacao;
	private StatusTransacao status;
}
