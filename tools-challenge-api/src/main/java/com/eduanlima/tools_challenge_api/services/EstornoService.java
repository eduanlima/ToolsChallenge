package com.eduanlima.tools_challenge_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduanlima.tools_challenge_api.dto.TransacaoDTO;
import com.eduanlima.tools_challenge_api.dto.TransacaoFormulario;
import com.eduanlima.tools_challenge_api.entities.base.Transacao;
import com.eduanlima.tools_challenge_api.entities.model.Descricao;
import com.eduanlima.tools_challenge_api.entities.model.Estorno;
import com.eduanlima.tools_challenge_api.entities.model.FormaPagamento;
import com.eduanlima.tools_challenge_api.entities.model.Pagamento;
import com.eduanlima.tools_challenge_api.repositories.EstornoRepository;
import com.eduanlima.tools_challenge_api.repositories.PagamentoRepository;
import com.eduanlima.tools_challenge_api.utils.SimuladorCartaoCredito;

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

	public TransacaoFormulario inserir(String idPagamento) {
		//Buscar pagamento
		Pagamento pagamento = pagamentoRepository.buscarPorId(idPagamento);
		
		if (pagamento == null)
			return null; //Não autorizado
		
		Estorno estorno = estornoRepository.buscarEstornoPorIdPagamento(pagamento.getId());
		
		if (estorno != null)
			return new TransacaoFormulario(new TransacaoDTO(estorno));
		
		//Aplicar devolução
		estorno = copiarDadosPagamentoParaEstorno(pagamento);
		estorno.processarEstorno(pagamento.getDescricao().getStatus());
		estorno.valorCreditar();
		estorno = estornoRepository.inserir(estorno);
		
		SimuladorCartaoCredito.adicionarValor(pagamento.getCartao(), estorno.valorCreditar());
				
		return new TransacaoFormulario(new TransacaoDTO(estorno));
	}

	private Estorno copiarDadosPagamentoParaEstorno(Pagamento pagamento) {
		Estorno estorno = new Estorno();
		
		Descricao descricao = new Descricao(pagamento.getDescricao().getValor(),
				pagamento.getDescricao().getEstabelecimento(),
				estornoRepository.obterUltimoNsu(),
				estornoRepository.obterUltimoCodigoAutorizacao());

		FormaPagamento formaEstorno = new FormaPagamento(pagamento.getFormaPagamento().getTipo(),
				pagamento.getFormaPagamento().getParcelas());

		estorno.setIdPagamento(pagamento.getId());
		estorno.setCartao(pagamento.getCartao());
		estorno.setDescricao(descricao);
		estorno.setFormaPagamento(formaEstorno);
		return estorno;
	}
}
