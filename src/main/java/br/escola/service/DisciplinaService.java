package br.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.escola.model.Disciplina;
import br.escola.repository.DisciplinaRepository;
import br.escola.request.DisciplinaRequest;
import br.escola.response.BaseResponse;
import br.escola.response.ListDisciplinaResponse;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository _repository;

	// CRIAR DISCIPLINA
	public BaseResponse criar(DisciplinaRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome() == "" || request.getNome().isEmpty()) {
			response.message = "Campo nome não pode ser vazio";
			return response;
		}

		Disciplina disciplina = new Disciplina();
		disciplina.setNome(request.getNome());

		_repository.save(disciplina);
		response.message = "Disciplina criada com sucesso!";
		response.statusCode = 201;

		return response;
	}

	// OBTER TODAS AS DISCIPLINAS
	public ListDisciplinaResponse listar() {

		List<Disciplina> lista = _repository.findAll();

		ListDisciplinaResponse response = new ListDisciplinaResponse();
		response.setDisciplinas(lista);
		response.message = "Lista obtida com sucesso";
		response.statusCode = 200;

		return response;
	}
	
	// ATUALIZAR DISCIPLINA POR ID
		public BaseResponse atualizar(Long id, DisciplinaRequest disciplinaRequest) {

			Optional<Disciplina> disciplinaExistente = _repository.findById(id);
			Long idTemp = disciplinaExistente.get().getId();

			BaseResponse response = new BaseResponse();
			response.statusCode = 400;

			if (disciplinaRequest.getNome() == null || disciplinaRequest.getNome() == "") {
				response.message = "Campo de disciplina não foi preenchido";
				return response;
			}

			Disciplina disciplina = new Disciplina();
			disciplina.setId(idTemp);
			disciplina.setNome(disciplinaRequest.getNome());

			_repository.save(disciplina);

			response.statusCode = 200;
			response.message = "Disciplina atualizada com sucesso";

			return response;
		}
}
