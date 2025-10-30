package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.eduanlima.tools_challenge_api.entities.enums.StatusTransacao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Descricao {
	private BigDecimal valor; 
	private Timestamp datahora;
	private String estabelecimento;
	private Integer nsu;
	private Integer codigoAutorizacao;
	private StatusTransacao status;
	
	private static final ZonedDateTime timeZoneAtual = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
	
	public Descricao(BigDecimal valor, Timestamp datahora, String estabelecimento, Integer nsu,
			Integer codigoAutorizacao, StatusTransacao status) {
		this.valor = valor;
		this.datahora = datahora;
		this.estabelecimento = estabelecimento;
		this.nsu = nsu;
		this.codigoAutorizacao = codigoAutorizacao;
		this.status = status;
		
		capturarDataAtual();
	}
	
	private final void capturarDataAtual() {
		if (datahora == null) 
			datahora = Timestamp.valueOf(timeZoneAtual.toLocalDateTime());
	}
}
