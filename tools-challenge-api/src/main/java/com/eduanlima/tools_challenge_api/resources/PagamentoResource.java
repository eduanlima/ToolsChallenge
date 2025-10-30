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
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<TransacaoFormulario> buscarPorId(@PathVariable Long id) {
		return null; //pagamentoService.buscarPorId(id);
	} 
	
	@GetMapping
	public ResponseEntity<List<TransacaoFormulario>> buscarTodos(@PathVariable Long id) {
		return null; //pagamentoService.buscarTodos();
	} 
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TransacaoFormulario> inserir(@PathVariable(required = false) Long id, @RequestBody TransacaoFormulario dto) {
		//dto = pagamentoService.inserir(id, dto);
		return ResponseEntity.ok(dto);
	}
}
