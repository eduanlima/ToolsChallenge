package com.eduanlima.tools_challenge_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduanlima.tools_challenge_api.dto.TransacaoFormulario;
import com.eduanlima.tools_challenge_api.services.EstornoService;

@RestController
@RequestMapping("/estorno")
public class EstornoResource {
	@Autowired
	private EstornoService estornoService;

	@GetMapping
	public ResponseEntity<List<TransacaoFormulario>> listar() {
		return ResponseEntity.ok(estornoService.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransacaoFormulario> buscarPorId(@PathVariable String id) {
		return ResponseEntity.ok(estornoService.buscaPorId(id));
	}

	@PutMapping("/{idPagamento}")
	public ResponseEntity<TransacaoFormulario> inserir(@PathVariable String idPagamento) {
		return ResponseEntity.ok(estornoService.inserir(idPagamento));
	}
}
