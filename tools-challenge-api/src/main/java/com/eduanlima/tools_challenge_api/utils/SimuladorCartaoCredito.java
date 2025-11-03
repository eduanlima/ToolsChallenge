package com.eduanlima.tools_challenge_api.utils;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.eduanlima.tools_challenge_api.utils.exceptions.CartaoNaoEncontrado;

public class SimuladorCartaoCredito {
	private static final Map<String, BigDecimal> cartoes = new LinkedHashMap<>();

	public SimuladorCartaoCredito() {
		cartoes.put("1111********0000", new BigDecimal("1000.00"));
		cartoes.put("2222********0000", new BigDecimal("2000.00"));
		cartoes.put("3333********0000", new BigDecimal("3000.00"));
		cartoes.put("4444********0000", new BigDecimal("4000.00"));
		cartoes.put("5555********0000", new BigDecimal("5000.00"));
		
		for (Map.Entry<String, BigDecimal> entry : cartoes.entrySet()) {
		    System.out.println("Cartão: " + entry.getKey() + " | Valor: " + entry.getValue());
		}
	}
	
	public static void adicionarValor(String numeroCartao, BigDecimal valor) {		
		BigDecimal saldoAtual = cartoes.get(numeroCartao);
		BigDecimal novoSaldo = saldoAtual.add(valor);

		cartoes.put(numeroCartao, novoSaldo);

		exibirSaldos();
	}
	
	public static void subtrairValor(String numeroCartao, BigDecimal valor) {		
		BigDecimal saldoAtual = cartoes.get(numeroCartao);
		BigDecimal novoSaldo = saldoAtual.subtract(valor);

		if (novoSaldo.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Saldo insuficiente para o cartão: " + numeroCartao);
		}

		cartoes.put(numeroCartao, novoSaldo);
		exibirSaldos();
	}

	public static BigDecimal consultarValor(String numeroCartao) {
		if (!cartoes.containsKey(numeroCartao))
			throw new CartaoNaoEncontrado("Número do cartão é inválido.");
		
		return cartoes.get(numeroCartao);
	}

	private static final void exibirSaldos(){
		for (Map.Entry<String, BigDecimal> entry : cartoes.entrySet()) {
		    System.out.println("Cartão: " + entry.getKey() + " | Valor: " + entry.getValue());
		}
	}
}
