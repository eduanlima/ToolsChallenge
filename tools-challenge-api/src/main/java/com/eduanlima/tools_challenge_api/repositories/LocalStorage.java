package com.eduanlima.tools_challenge_api.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.Estorno;
import com.eduanlima.tools_challenge_api.entities.model.Pagamento;

public class LocalStorage {
	private static final Map<Long, Transacao> transacoes = new LinkedHashMap<>();
	
    public static synchronized Transacao inserir(Long id, Transacao transacao) {
    	transacoes.put(id != null ? id : transacao.getId(), transacao);
    	System.out.println("Total of transactions: " + transacoes.size());
        return transacao;
    }
    
    public static synchronized Transacao buscarPorId(Long id) {
        Transacao transacao = transacoes.get(id);
        return transacao;
    }
    
    public static synchronized List<Transacao> listar() {
        List<Transacao> listaTransacao = new ArrayList<>(transacoes.values());
        Collections.reverse(listaTransacao);
        return listaTransacao;
    }
    
    public static synchronized int[] obterUltimoNsuCodigoAutorizacao(Transacao transacao) {
    	//Por padrão: [0] = nsu e [1] = codigoAutorizacao
        List<Transacao> listaTransacoes = new ArrayList<>(transacoes.values());
        Collections.reverse(listaTransacoes);

        for (Transacao t : listaTransacoes) {
        	Descricao descricao = new Descricao();
        	
            if (t instanceof Pagamento) {
                Pagamento pagamento = (Pagamento) t;
                descricao = pagamento.getDescricao();
                
                if (descricao != null && descricao.getNsu() != null) 
                	return new int[] {descricao.getNsu(), descricao.getCodigoAutorizacao()};
            } 
            
            if (t instanceof Estorno) {
                Estorno estorno = (Estorno) t;
                descricao = estorno.getDescricao();
                if (descricao != null && descricao.getNsu() != null) 
                	return new int[] {descricao.getNsu(), descricao.getCodigoAutorizacao()};
            }
        }

        return new int[] {0, 0};
    }
}
