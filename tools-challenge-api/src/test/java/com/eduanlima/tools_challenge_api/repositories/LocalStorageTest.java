package com.eduanlima.tools_challenge_api.repositories;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.Estorno;
import com.eduanlima.tools_challenge_api.entities.model.Pagamento;

public class LocalStorageTest {
	@BeforeEach
	@SuppressWarnings("unchecked")
	void setup() throws Exception {
		Field field = LocalStorage.class.getDeclaredField("transacoes");
		field.setAccessible(true);
		Map<String, Transacao> transacoes = (Map<String, Transacao>) field.get(null);
		transacoes.clear();

		Descricao descricaoPagamento1 = new Descricao();
		descricaoPagamento1.setNsu("1000");
		descricaoPagamento1.setCodigoAutorizacao("10000");

		Descricao descricaoPagamento2 = new Descricao();
		descricaoPagamento2.setNsu("1001");
		descricaoPagamento2.setCodigoAutorizacao("10001");

		Pagamento pagamento1 = new Pagamento();
		pagamento1.setId("pagamento1");
		pagamento1.setDescricao(descricaoPagamento1);

		Pagamento pagamento2 = new Pagamento();
		pagamento2.setId("pagamento2");
		pagamento2.setDescricao(descricaoPagamento2);

		Descricao descricaoEstorno1 = new Descricao();
		descricaoEstorno1.setNsu("1000");
		descricaoEstorno1.setCodigoAutorizacao("10000");

		Descricao descricaoEstorno2 = new Descricao();
		descricaoEstorno2.setNsu("1001");
		descricaoEstorno2.setCodigoAutorizacao("10001");

		Descricao descricaoEstorno3 = new Descricao();
		descricaoEstorno3.setNsu("1002");
		descricaoEstorno3.setCodigoAutorizacao("10002");

		Estorno estorno1 = new Estorno();
		estorno1.setId("estorno1");
		estorno1.setDescricao(descricaoEstorno1);

		Estorno estorno2 = new Estorno();
		estorno2.setId("estorno2");
		estorno2.setDescricao(descricaoEstorno2);

		Estorno estorno3 = new Estorno();
		estorno3.setId("estorno3");
		estorno3.setDescricao(descricaoEstorno3);

		transacoes.put(pagamento1.getId(), pagamento1);
		transacoes.put(pagamento2.getId(), pagamento2);
		transacoes.put(estorno1.getId(), estorno1);
		transacoes.put(estorno2.getId(), estorno2);
		transacoes.put(estorno3.getId(), estorno3);
	}

	@Test
	void deveRetornarUltimosCodigosDoPagamento() {
		String[] resultado = LocalStorage.obterUltimoNsuCodigoAutorizacao(Pagamento.class);
		assertArrayEquals(new String[] { "1001", "10001" }, resultado);
	}

	@Test
	void deveRetornarUltimosCodigosDoEstorno() {
		String[] resultado = LocalStorage.obterUltimoNsuCodigoAutorizacao(Estorno.class);
		assertArrayEquals(new String[] { "1002", "10002" }, resultado);
	}
}
