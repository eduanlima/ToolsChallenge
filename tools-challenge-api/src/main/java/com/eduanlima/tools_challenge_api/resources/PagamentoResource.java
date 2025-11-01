package com.eduanlima.tools_challenge_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduanlima.tools_challenge_api.dto.TransacaoFormulario;
import com.eduanlima.tools_challenge_api.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoResource {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping
	public ResponseEntity<List<TransacaoFormulario>> listar() {
		return ResponseEntity.ok(pagamentoService.listar());
	} 
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<TransacaoFormulario> buscarPorId(@PathVariable("id") Long id) {
		TransacaoFormulario transacao = pagamentoService.buscaPorId(id);
		return ResponseEntity.ok(transacao);
	} 
	
	@PutMapping
	public ResponseEntity<TransacaoFormulario> inserir(@RequestBody TransacaoFormulario dto) {
		dto = pagamentoService.inserir(null, dto.getTransacao());
		return ResponseEntity.ok(dto);
	}
}
