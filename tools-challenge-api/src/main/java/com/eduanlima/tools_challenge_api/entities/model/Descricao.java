package com.eduanlima.tools_challenge_api.entities.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	private Timestamp dataHora;
	private String estabelecimento;
	@Getter
	private String nsu;
	@Getter
	private String codigoAutorizacao;
	private StatusTransacao status;

	private final ZonedDateTime timeZoneAtual = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));

	public Descricao(BigDecimal valor, String estabelecimento, StatusTransacao status, String ultimoNsu,
			String ultimoCodigoAutorizacao) {
		this.valor = valor.setScale(2, RoundingMode.HALF_UP);
		this.estabelecimento = estabelecimento;
		this.status = status;

		capturarDataAtual();
		gerarNsu(ultimoNsu);
		gerarCodigoAutorizacao(ultimoCodigoAutorizacao);
	}

	private final void capturarDataAtual() {
		dataHora = Timestamp.valueOf(timeZoneAtual.toLocalDateTime());
	}

	private final void gerarNsu(String ultimoNsu) {
		int nsuNumerico = Integer.parseInt(ultimoNsu);
		
		if (nsuNumerico == 0)
			nsu = String.valueOf(1000);
		else
			nsu = String.valueOf(nsuNumerico + 1);
	}

	public final void gerarCodigoAutorizacao(String ultimoCodigoAutorizacao) {
		int codigoAutorizacaoNumerico = Integer.parseInt(ultimoCodigoAutorizacao);
		
		if (codigoAutorizacaoNumerico == 0)
			codigoAutorizacao = String.valueOf(10000);
		else
			codigoAutorizacao = String.valueOf(codigoAutorizacaoNumerico + 1);
	}
}
