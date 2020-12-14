package br.escola.response;

import java.util.List;

import br.escola.model.Professor;

public class ListProfessorResponse extends BaseResponse {

	public List<Professor> professores;

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
}
