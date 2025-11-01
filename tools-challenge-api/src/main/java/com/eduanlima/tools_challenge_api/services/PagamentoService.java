package com.eduanlima.tools_challenge_api.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduanlima.tools_challenge_api.dto.TransacaoDTO;
import com.eduanlima.tools_challenge_api.dto.TransacaoFormulario;
import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.FormaPagamento;
import com.eduanlima.tools_challenge_api.entities.model.Pagamento;
import com.eduanlima.tools_challenge_api.repositories.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public TransacaoFormulario buscaPorId(String id){
		Transacao entidade = pagamentoRepository.buscarPorId(id);
		return new TransacaoFormulario(new TransacaoDTO((Pagamento) entidade));
	}
	
	public List<TransacaoFormulario> listar() {
		List<Transacao> lista = pagamentoRepository.listar();
	
		return lista.stream()
			.map(transacao -> new TransacaoFormulario(new TransacaoDTO((Pagamento) transacao)))
			.toList();
	}
	
	public TransacaoFormulario inserir(String id, TransacaoDTO dto) {
		Transacao entidade = pagamentoRepository.inserir(id, converterDTO(dto));
		return new TransacaoFormulario(new TransacaoDTO((Pagamento) entidade));
	}

	private Pagamento converterDTO(TransacaoDTO dto) {		
		Descricao descricao = new Descricao(new BigDecimal(dto.getDescricao().getValor()), dto.getDescricao().getEstabelecimento(),
				dto.getDescricao().getStatus(), pagamentoRepository.obterUltimoNsu(new Pagamento()),
				pagamentoRepository.obterUltimoCodigoAutorizacao(new Pagamento()));

		FormaPagamento formaPagamento = new FormaPagamento(dto.getFormaPagamento().getTipo(),
				dto.getFormaPagamento().getParcelas());

		return new Pagamento(dto.getCartao(), descricao, formaPagamento);
	}
}
