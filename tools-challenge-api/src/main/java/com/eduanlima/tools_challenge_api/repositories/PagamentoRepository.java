package com.eduanlima.tools_challenge_api.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Pagamento;

@Repository
public class PagamentoRepository {
	public Transacao buscarPorId(String id) {
		return LocalStorage.buscarPorId(id, Pagamento.class);
	}

	public List<Pagamento> listar() {
		return LocalStorage.listar(Pagamento.class).stream().filter(t -> t instanceof Pagamento).map(t -> (Pagamento) t)
				.collect(Collectors.toList());
	}

	public Transacao inserir(Transacao entidade) {
		return LocalStorage.inserir(entidade);
	}

	public String obterUltimoNsu() {
		return LocalStorage.obterUltimoNsuCodigoAutorizacao(Pagamento.class)[0];
	}

	public String obterUltimoCodigoAutorizacao() {
		return LocalStorage.obterUltimoNsuCodigoAutorizacao(Pagamento.class)[1];
	}
}
