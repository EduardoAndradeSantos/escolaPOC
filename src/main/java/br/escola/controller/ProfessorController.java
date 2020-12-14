package br.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.escola.request.ProfessorRequest;
import br.escola.response.BaseResponse;
import br.escola.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController extends BaseController {

	@Autowired
	ProfessorService _service;

	// POST - CRIAR PROFESSOR
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ProfessorRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR TODOS OS PROFESSORES
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			BaseResponse response = _service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// PUT - ATUALIZAR PROFESSOR POR ID
	@PutMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> atualizar(@RequestBody ProfessorRequest professorRequest,
			@PathVariable Long id) {
		try {
			BaseResponse response = _service.atualizar(id, professorRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
