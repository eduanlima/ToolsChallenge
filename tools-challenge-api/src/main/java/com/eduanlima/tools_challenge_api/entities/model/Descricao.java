package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.eduanlima.tools_challenge_api.entities.enums.StatusTransacao;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Descricao {
	private BigDecimal valor;
	private Timestamp datahora;
	private String estabelecimento;
	@Getter
	private Integer nsu;
	@Getter
	private Integer codigoAutorizacao;
	private StatusTransacao status;

	private final ZonedDateTime timeZoneAtual = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));

	public Descricao(BigDecimal valor, String estabelecimento, StatusTransacao status, int ultimoNsu,
			int ultimoCodigoAutorizacao) {
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.status = status;

		capturarDataAtual();
		gerarNsu(ultimoNsu);
		gerarCodigoAutorizacao(ultimoCodigoAutorizacao);
	}

	private final void capturarDataAtual() {
		datahora = Timestamp.valueOf(timeZoneAtual.toLocalDateTime());
	}

	private final void gerarNsu(Integer ultimoNsu) {
		if (ultimoNsu == 0)
			nsu = 1000;
		else
			nsu = ultimoNsu + 1;
	}

	public final void gerarCodigoAutorizacao(Integer ultimoCodigoAutorizacao) {
		if (ultimoCodigoAutorizacao == 0)
			codigoAutorizacao = 10000;
		else
			codigoAutorizacao = ultimoCodigoAutorizacao + 1;
	}
}
