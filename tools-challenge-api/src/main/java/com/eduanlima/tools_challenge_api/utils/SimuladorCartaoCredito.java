package com.eduanlima.tools_challenge_api.utils;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;


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
	
	public void adicionarValor() {
		
	}
	
	public void subtrairValor() {
		
	}
}
