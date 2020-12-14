package br.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.escola.model.Aluno;
import br.escola.model.Avaliacao;
import br.escola.model.Disciplina;
import br.escola.model.Professor;
import br.escola.model.ProfessorDisciplina;
import br.escola.repository.AlunoRepository;
import br.escola.repository.AvaliacaoRepository;
import br.escola.repository.DisciplinaRepository;
import br.escola.repository.ProfessorDisciplinaRepository;
import br.escola.repository.ProfessorRepository;
import br.escola.request.AvaliacaoRequest;
import br.escola.response.AlunoResponse;
import br.escola.response.AvaliacaoResponse;
import br.escola.response.BaseResponse;
import br.escola.response.DisciplinaResponse;
import br.escola.response.ListAvaliacaoResponse;
import br.escola.response.ProfessorResponse;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepository _repository;
	
	@Autowired
	DisciplinaRepository _disciplinaRepository;
	
	@Autowired
	ProfessorRepository _professorRepository;
	
	@Autowired
	AlunoRepository _alunoRepository;
	
	@Autowired
	ProfessorDisciplinaRepository _professorDisciplinaRepository;

	// CRIAR AVALIACAO
	public BaseResponse criar(AvaliacaoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getAlunoId() <= 0 || request.getAlunoId() == null) {
			response.message = "Id do aluno precisa ser inserido";
			return response;
		} else if (request.getProfessorDisciplinaId() <= 0 || request.getProfessorDisciplinaId() == null) {
			response.message = "Id de ProfessorDisciplina precisa ser inserido";
			return response;
		} else if (request.getAv1() < 0) {
			response.message = "Campo AV1 não pode ser menor que zero";
			return response;
		} else if (request.getAv2() < 0) {
			response.message = "Campo AV2 não pode ser menor que zero";
			return response;
		}

		// INSTANCIA
		Avaliacao avaliacao = new Avaliacao();

		// INSERE ID DO REQUEST EM UM ID DO MANY TO ONE ALUNO
		Aluno obj1 = new Aluno();
		obj1.setId(request.getAlunoId());
		avaliacao.setAluno(obj1);

		// INSERE ID DO REQUEST EM UM ID DO MANY TO ONE PROFESSORDISCIPLINA
		ProfessorDisciplina obj2 = new ProfessorDisciplina();
		obj2.setId(request.getProfessorDisciplinaId());
		avaliacao.setProfessorDisciplina(obj2);

		avaliacao.setAv1(request.getAv1());
		avaliacao.setAv2(request.getAv2());

		_repository.save(avaliacao);
		response.message = "Avaliação criada com sucesso";
		response.statusCode = 201;

		return response;
	}

	// OBTER AVALIACAO POR ID
	public AvaliacaoResponse obter(Long id) {
		Optional<Avaliacao> avaliacao = _repository.findById(id);
		
		Optional<Aluno> aluno = _alunoRepository.findById(avaliacao.get().getAluno().getId());
		
		Optional<ProfessorDisciplina> professorDisciplina = _professorDisciplinaRepository.findById(avaliacao.get().getProfessorDisciplina().getId());

		Optional<Professor> professor = _professorRepository.findById(professorDisciplina.get().getProfessor().getId());
		
		Optional<Disciplina> disciplina = _disciplinaRepository.findById(professorDisciplina.get().getDisciplina().getId());
		
		AvaliacaoResponse response = new AvaliacaoResponse();

		response.setId(avaliacao.get().getId());
		
		AlunoResponse obj = new AlunoResponse();
		obj.setId(aluno.get().getId());
		obj.setNome(aluno.get().getNome());
		response.setAluno(obj);
		
		ProfessorResponse obj2 = new ProfessorResponse();
		obj2.setId(professor.get().getId());
		obj2.setNome(professor.get().getNome());
		response.setProfessor(obj2);
		
		DisciplinaResponse obj3 = new DisciplinaResponse();
		obj3.setId(disciplina.get().getId());
		obj3.setNome(disciplina.get().getNome());
		response.setDisciplina(obj3);
		
		response.setAv1(avaliacao.get().getAv1());
		response.setAv2(avaliacao.get().getAv2());

		Double media = (((avaliacao.get().getAv1()) + (avaliacao.get().getAv2())) / 2);
		if (media >= 6) {
			response.setSituacao("Aprovado");
		} else {
			response.setSituacao("Reprovado");
		}

		response.statusCode = 200;
		response.message = "Aluno obtido com sucesso.";

		return response;
	}

	public ListAvaliacaoResponse listar() {

		List<Avaliacao> lista = _repository.findAll();

		ListAvaliacaoResponse response = new ListAvaliacaoResponse();
		response.setAvaliacoes(lista);
		response.statusCode = 200;
		response.message = "Lista obtida com sucesso.";

		return response;
	}

}
