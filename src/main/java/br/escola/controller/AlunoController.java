package br.escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.escola.service.AlunoService;
import br.escola.request.AlunoRequest;
import br.escola.response.BaseResponse;

@RestController
@RequestMapping("/alunos")
public class AlunoController extends BaseController {

	@Autowired
	AlunoService _service;

	// POST - CRIAR ALUNO
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody AlunoRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - OBTER UM ALUNO POR ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - LISTAR TODOS OS ALUNOS
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			BaseResponse response = _service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// PUT - ATUALIZAR POR ID DO ALUNO
	@PutMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> atualizar(@RequestBody AlunoRequest alunoRequest, @PathVariable Long id) {
		try {
			BaseResponse response = _service.atualizar(id, alunoRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// DELETE - DELETAR ALUNO
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> deletar(@PathVariable Long id) {
		try {
			BaseResponse response = _service.deletar(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}