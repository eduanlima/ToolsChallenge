package com.eduanlima.tools_challenge_api.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.Estorno;

public class LocalStorage {
	private static final Map<String, Transacao> transacoes = new LinkedHashMap<>();

	public static synchronized Transacao inserir(Transacao transacao) {
		transacoes.put(transacao.getId(), transacao);
		return transacao;
	}

	public static synchronized <T extends Transacao> T buscarPorId(String id, Class<T> tipoTransacao) {
		Transacao transacao = transacoes.get(id);

		if (tipoTransacao.isInstance(transacao))
			return tipoTransacao.cast(transacao);

		return null;
	}

	public static synchronized <T extends Transacao> List<T> listar(Class<T> tipoTransacao) {
		return transacoes.values().stream().filter(tipoTransacao::isInstance).map(tipoTransacao::cast)
				.collect(Collectors.collectingAndThen(Collectors.toList(), lista -> {
					Collections.reverse(lista);
					return lista;
				}));
	}

	public static synchronized Estorno buscarEstornoPorIdPagamento(String idPagamento) {
		return transacoes.values().stream().filter(Estorno.class::isInstance).map(Estorno.class::cast)
				.filter(e -> idPagamento.equals(e.getIdPagamento())).findFirst().orElse(null);
	}

	public static synchronized <T extends Transacao> String[] obterUltimoNsuCodigoAutorizacao(Class<T> tipoTransacao) {
		// Por padrão: [0] = nsu e [1] = codigoAutorizacao
		List<Transacao> listaTransacoes = new ArrayList<>(transacoes.values());
		Collections.reverse(listaTransacoes);

		for (Transacao t : listaTransacoes) {
			Descricao descricao = new Descricao();

			if (tipoTransacao.isInstance(t)) {
				descricao = t.getDescricao();

				if (descricao != null && descricao.getNsu() != null)
					return new String[] { String.valueOf(descricao.getNsu()),
							String.valueOf(descricao.getCodigoAutorizacao()) };
			}
		}

		return new String[] { "0", "0" };
	}
}
