package com.eduanlima.tools_challenge_api;

import com.eduanlima.tools_challenge_api.model.Pagamento;
import com.eduanlima.tools_challenge_api.model.Transacao;

import lombok.Data;

@Data
public class Estorno extends Transacao {
	private Pagamento pagamento;
	
	@Override
	public void processar() {
		// TODO Auto-generated method stub

	}

}
