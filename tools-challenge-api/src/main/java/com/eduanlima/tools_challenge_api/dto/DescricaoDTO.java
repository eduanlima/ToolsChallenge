package com.eduanlima.tools_challenge_api.dto;

import java.time.format.DateTimeFormatter;

import com.eduanlima.tools_challenge_api.entities.enums.StatusTransacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescricaoDTO {
	private String valor;
	private String dataHora;
	private String estabelecimento;
	private String nsu;
	private String codigoAutorizacao;
	private StatusTransacao status;

	private static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public DescricaoDTO(Descricao descricao) {
		this.valor = descricao.getValor().toPlainString();
		this.dataHora = descricao.getDataHora().toLocalDateTime().format(formatoData);
		this.estabelecimento = descricao.getEstabelecimento();
		this.nsu = descricao.getNsu();
		this.codigoAutorizacao = descricao.getCodigoAutorizacao();
		this.status = descricao.getStatus();
	}
}
