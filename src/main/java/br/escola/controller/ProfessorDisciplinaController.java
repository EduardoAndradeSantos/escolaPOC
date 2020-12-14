package br.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.escola.request.ProfessorDisciplinaRequest;
import br.escola.response.BaseResponse;
import br.escola.service.ProfessorDisciplinaService;

@RestController
@RequestMapping("/professoresDisciplinas")
public class ProfessorDisciplinaController extends BaseController {

	@Autowired
	ProfessorDisciplinaService _service;

	// POST - CRIAR PROFESSORDISCIPLINA
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody ProfessorDisciplinaRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR TUDO
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			BaseResponse response = _service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
}
