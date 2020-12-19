package br.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.escola.request.AvaliacaoRequest;
import br.escola.response.BaseResponse;
import br.escola.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController extends BaseController {

	@Autowired
	AvaliacaoService _service;

	// POST - CRIAR AVALIACAO
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody AvaliacaoRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - OBTER AVALIACAO POR ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR TODAS AS AVALIACOES
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			BaseResponse response = _service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	// GET - OBTER AVALICOES DE UM ALUNO POR ID DO ALUNO
		@GetMapping(path = "/aluno/{id}")
		public ResponseEntity<BaseResponse> obterAluno(@PathVariable Long id) {
			try {
				BaseResponse response = _service.obterAluno(id);
				return ResponseEntity.status(response.statusCode).body(response);
			} catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
			}
		}

}
