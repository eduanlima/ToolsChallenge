package com.eduanlima.tools_challenge_api.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Estorno;

@Repository
public class EstornoRepository {
	public Transacao buscarPorId(String id) {
		return LocalStorage.buscarPorId(id, Estorno.class);
	}

	public List<Estorno> listar() {
		return LocalStorage.listar(Estorno.class).stream().filter(t -> t instanceof Estorno).map(t -> (Estorno) t)
				.collect(Collectors.toList());
	}

	public Transacao inserir(Transacao entidade) {
		return LocalStorage.inserir(entidade);
	}

	public String obterUltimoNsu() {
		return LocalStorage.obterUltimoNsuCodigoAutorizacao(Estorno.class)[0];
	}

	public String obterUltimoCodigoAutorizacao() {
		return LocalStorage.obterUltimoNsuCodigoAutorizacao(Estorno.class)[1];
	}
}
