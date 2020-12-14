package br.escola.response;

import java.util.List;

import br.escola.model.Aluno;

public class ListAlunoResponse extends BaseResponse {

	public List<Aluno> alunos;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
