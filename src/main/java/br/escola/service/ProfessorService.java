package br.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.escola.model.Professor;
import br.escola.repository.ProfessorRepository;
import br.escola.request.ProfessorRequest;
import br.escola.response.BaseResponse;
import br.escola.response.ListProfessorResponse;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository _repository;

	// CRIAR PROFESSOR
	public BaseResponse criar(ProfessorRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome() == "" || request.getNome().isEmpty()) {
			response.message = "Campo nome não pode ser vazio";
			return response;
		}

		Professor professor = new Professor();
		professor.setNome(request.getNome());

		_repository.save(professor);
		response.message = "Professor criado com sucesso!";
		response.statusCode = 201;

		return response;
	}

	// OBTER TODOS OS PROFESSORES
	public ListProfessorResponse listar() {

		List<Professor> lista = _repository.findAll();

		ListProfessorResponse response = new ListProfessorResponse();
		response.setProfessores(lista);
		response.message = "Lista obtida com sucesso";
		response.statusCode = 200;

		return response;
	}

	// ATUALIZAR PROFESSOR POR ID
	public BaseResponse atualizar(Long id, ProfessorRequest professorRequest) {

		Optional<Professor> professorExistente = _repository.findById(id);
		Long idTemp = professorExistente.get().getId();

		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (professorRequest.getNome() == null || professorRequest.getNome() == "") {
			response.message = "Campo professor não foi preenchido";
			return response;
		}

		Professor professor = new Professor();
		professor.setId(idTemp);
		professor.setNome(professorRequest.getNome());

		_repository.save(professor);

		response.statusCode = 200;
		response.message = "Professor atualizado com sucesso";

		return response;
	}

}
