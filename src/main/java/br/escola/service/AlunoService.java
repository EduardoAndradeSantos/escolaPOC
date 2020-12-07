package br.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.escola.model.Aluno;
import br.escola.repository.AlunoRepository;
import br.escola.request.AlunoRequest;
import br.escola.response.BaseResponse;
import br.escola.response.ListAlunoResponse;
import br.escola.response.AlunoResponse;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository _repository;

	// CRIAR ALUNO
	public BaseResponse criarAluno(AlunoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome() == "" || request.getNome().isEmpty()) {
			response.message = "Campo nome não pode ser vazio";
			return response;
		} else if (request.getAv1() < 0) {
			response.message = "Campo AV1 não pode ser menor que zero";
			return response;
		} else if (request.getAv2() < 0) {
			response.message = "Campo AV2 não pode ser menor que zero";
			return response;
		}

		Aluno aluno = new Aluno();
		aluno.setNome(request.getNome());
//		aluno.setAv1(request.getAv1());
//		aluno.setAv2(request.getAv2());

		_repository.save(aluno);
		response.message = "Aluno criado com sucesso!";
		response.statusCode = 201;

		return response;
	}

	// OBTER ALUNO POR ID
	public AlunoResponse obter(Long id) {
		Optional<Aluno> aluno = _repository.findById(id);

		AlunoResponse response = new AlunoResponse();

		response.setId(aluno.get().getId());
		response.setNome(aluno.get().getNome());
//		response.setAv1(aluno.get().getAv1());
//		response.setAv2(aluno.get().getAv2());
//
//		Double media = (((aluno.get().getAv1()) + (aluno.get().getAv2())) / 2);
//		if (media >= 7) {
//			response.setSituacao("Aprovado");
//		} else {
//			response.setSituacao("Reprovado");
//		}

		response.statusCode = 200;
		response.message = "Aluno obtido com sucesso.";

		return response;
	}
	
	//OBTER TODOS OS ALUNOS
	public ListAlunoResponse listar() {
		
		List<Aluno> lista = _repository.findAll();
		
		ListAlunoResponse response = new ListAlunoResponse();
		response.setAlunos(lista);
		response.message = "Lista obtida com sucesso";
		response.statusCode = 200;
		
		return response;
	}
	
	// ATUALIZAR ALUNO POR ID
	public BaseResponse atualizar(Long id, AlunoRequest alunoRequest) {
		
		Optional<Aluno> alunoExistente = _repository.findById(id);
		Long idTemp = alunoExistente.get().getId();
		
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if (alunoRequest.getNome() == null || alunoRequest.getNome() == "") {
			response.message = "novo nome de aluno não foi preenchido";
		}
		
		Aluno aluno = new Aluno();
		aluno.setId(idTemp);
		aluno.setNome(alunoRequest.getNome());
		
		_repository.save(aluno);
		
		response.statusCode = 200;
		response.message = "Aluno atualizado com sucesso";
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
