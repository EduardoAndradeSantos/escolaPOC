package br.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.escola.model.Disciplina;
import br.escola.model.Professor;
import br.escola.model.ProfessorDisciplina;
import br.escola.repository.ProfessorDisciplinaRepository;
import br.escola.request.ProfessorDisciplinaRequest;
import br.escola.response.BaseResponse;
import br.escola.response.ListProfessorDisciplinaResponse;

@Service
public class ProfessorDisciplinaService {

	@Autowired
	ProfessorDisciplinaRepository _repository;
	
	public BaseResponse criar(ProfessorDisciplinaRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if (request.getProfessorId() <= 0 || request.getProfessorId() == null) {
				response.message = "Id de professor precisa ser inserido";
				return response;
			} else if (request.getDisciplinaId() <= 0 || request.getDisciplinaId() == null) {
				response.message = "Id de disciplina precisa ser inserido";
				return response;
			}
		
		ProfessorDisciplina professorDisciplina = new ProfessorDisciplina();
		
		// INSERE ID DO REQUEST EM UM ID DO MANY TO ONE PROFESSOR
		Professor obj1 = new Professor();
		obj1.setId(request.getProfessorId());
		professorDisciplina.setProfessor(obj1);
		
		// INSERE ID DO REQUEST EM UM ID DO MANY TO ONE DISCIPLINA
		Disciplina obj2 = new Disciplina();
		obj2.setId(request.getDisciplinaId());
		professorDisciplina.setDisciplina(obj2);
		
		_repository.save(professorDisciplina);
		
		response.message = "ProfessorDisciplina criado com sucesso!";
		response.statusCode = 201;
		
		return response;
	}
	
	public ListProfessorDisciplinaResponse listar() {

		List<ProfessorDisciplina> lista = _repository.findAll();

		ListProfessorDisciplinaResponse response = new ListProfessorDisciplinaResponse();
		response.setProfessoresDisciplinas(lista);
		response.statusCode = 200;
		response.message = "Lista obtida com sucesso.";

		return response;
	}
}
