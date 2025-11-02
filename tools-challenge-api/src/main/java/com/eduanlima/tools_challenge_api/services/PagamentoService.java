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
import com.eduanlima.tools_challenge_api.utils.SimuladorCartaoCredito;

@Service
public class PagamentoService {
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	//Cálculo juros com taxa de 10% ao mês
	private final static BigDecimal TAXA_JUROS = new BigDecimal("0.1");
	
	public TransacaoFormulario buscaPorId(String id){
		Transacao pagamento = pagamentoRepository.buscarPorId(id);
		return new TransacaoFormulario(new TransacaoDTO((Pagamento) pagamento));
	}
	
	public List<TransacaoFormulario> listar() {
		List<Pagamento> lista = pagamentoRepository.listar();
	
		return lista.stream()
			.map(pagamento -> new TransacaoFormulario(new TransacaoDTO(pagamento)))
			.toList();
	}
	
	public TransacaoFormulario inserir(TransacaoDTO dto) {
		Transacao transacao = pagamentoRepository.buscarPorId(dto.getId());
		
		if (transacao != null)
			return new TransacaoFormulario(new TransacaoDTO((Pagamento) transacao));
	
		Pagamento pagamento = converterDTO(dto);
		BigDecimal limiteDisponivelCartao = SimuladorCartaoCredito.consultarValor(pagamento.getCartao());
		pagamento.processarPagamento(limiteDisponivelCartao, TAXA_JUROS);
		pagamento = pagamentoRepository.inserir(pagamento);
		
		SimuladorCartaoCredito.subtrairValor(pagamento.getCartao(), pagamento.valorDebitar());

		return new TransacaoFormulario(new TransacaoDTO(pagamento));
	}

	private Pagamento converterDTO(TransacaoDTO dto) {		
		Descricao descricao = new Descricao(new BigDecimal(dto.getDescricao().getValor()), dto.getDescricao().getEstabelecimento(),
				dto.getDescricao().getStatus(), pagamentoRepository.obterUltimoNsu(),
				pagamentoRepository.obterUltimoCodigoAutorizacao());

		FormaPagamento formaPagamento = new FormaPagamento(dto.getFormaPagamento().getTipo(),
				dto.getFormaPagamento().getParcelas());

		return new Pagamento(dto.getId(), dto.getCartao(), descricao, formaPagamento);
	}
}
