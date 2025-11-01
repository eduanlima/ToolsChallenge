package com.eduanlima.tools_challenge_api.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduanlima.tools_challenge_api.dto.TransacaoDTO;
import com.eduanlima.tools_challenge_api.dto.TransacaoFormulario;
import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.Estorno;
import com.eduanlima.tools_challenge_api.entities.model.FormaPagamento;
import com.eduanlima.tools_challenge_api.repositories.EstornoRepository;
import com.eduanlima.tools_challenge_api.repositories.PagamentoRepository;

@Service
public class EstornoService {
	@Autowired
	private EstornoRepository estornoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public TransacaoFormulario buscaPorId(String id) {
		Transacao estorno = estornoRepository.buscarPorId(id);
		return new TransacaoFormulario(new TransacaoDTO((Estorno) estorno));
	}

	public List<TransacaoFormulario> listar() {
		List<Estorno> lista = estornoRepository.listar();

		return lista.stream().map(estorno -> new TransacaoFormulario(new TransacaoDTO(estorno)))
				.toList();
	}

	public TransacaoFormulario inserir(String idPagamento, TransacaoDTO dto) {
		Transacao transacao = estornoRepository.buscarPorId(dto.getId());
		
		if (transacao != null)
			return new TransacaoFormulario(new TransacaoDTO((Estorno) transacao));
		
		//Buscar pagamento
		transacao = pagamentoRepository.buscarPorId(idPagamento);
		
		if (transacao == null)
			return null; //Não autorizado
		
		//Garantir integridade do dado
		idPagamento = transacao.getId();
		
		//Aplicar devolução
		
		transacao = estornoRepository.inserir(converterDTO(idPagamento, dto));
		
		return new TransacaoFormulario(new TransacaoDTO((Estorno) transacao));
	}

	private Estorno converterDTO(String idPagamento, TransacaoDTO dto) {
		Descricao descricao = new Descricao(new BigDecimal(dto.getDescricao().getValor()),
				dto.getDescricao().getEstabelecimento(), dto.getDescricao().getStatus(),
				estornoRepository.obterUltimoNsu(),
				estornoRepository.obterUltimoCodigoAutorizacao());

		FormaPagamento formaEstorno = new FormaPagamento(dto.getFormaPagamento().getTipo(),
				dto.getFormaPagamento().getParcelas());

		return new Estorno(dto.getId(), dto.getCartao(), descricao, formaEstorno, idPagamento);
	}
}
