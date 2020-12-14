package br.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.escola.request.DisciplinaRequest;
import br.escola.response.BaseResponse;
import br.escola.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController extends BaseController {

	@Autowired
	DisciplinaService _service;

	// POST - CRIAR DISCIPLINA
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody DisciplinaRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR TODAS AS DISCIPLINAS
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			BaseResponse response = _service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// PUT - ATUALIZAR DISCIPLINA POR ID
	@PutMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> atualizar(@RequestBody DisciplinaRequest disciplinaRequest,
			@PathVariable Long id) {
		try {
			BaseResponse response = _service.atualizar(id, disciplinaRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
