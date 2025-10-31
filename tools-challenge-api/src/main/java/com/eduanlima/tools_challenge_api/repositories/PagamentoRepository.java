package com.eduanlima.tools_challenge_api.repositories;

import org.springframework.stereotype.Repository;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Pagamento;

@Repository
public class PagamentoRepository {
	
	public Transacao inserir(Long id, Transacao entidade) {
		return LocalStorage.inserir(id, entidade);
	}
	
	public int obterUltimoNsu(Pagamento pagamento) {
		return LocalStorage.obterUltimoNsuCodigoAutorizacao(pagamento)[0];
	}
	
	public int obterUltimoCodigoAutorizacao(Pagamento pagamento) {
		return LocalStorage.obterUltimoNsuCodigoAutorizacao(pagamento)[1];
	}
}
