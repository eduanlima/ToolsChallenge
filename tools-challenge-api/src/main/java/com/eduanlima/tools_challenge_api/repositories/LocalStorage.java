package com.eduanlima.tools_challenge_api.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;

public class LocalStorage {
	private static final Map<Long, Transacao> transacoes = new LinkedHashMap<>();
	
    public static void inserir(Transacao transacao) {
        transacoes.put(transacao.getId(), transacao);
    }
    
    public static Transacao buscarPorId(Long id) {
        Transacao transacao = transacoes.get(id);
        return transacao;
    }
    
    public static List<Transacao> listar() {
        List<Transacao> listaTransacao = new ArrayList<>(transacoes.values());
        Collections.reverse(listaTransacao);
        return listaTransacao;
    }
}
