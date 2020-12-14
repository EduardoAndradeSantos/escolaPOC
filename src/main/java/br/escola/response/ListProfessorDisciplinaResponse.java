package br.escola.response;

import java.util.List;

import br.escola.model.ProfessorDisciplina;

public class ListProfessorDisciplinaResponse extends BaseResponse {

	List<ProfessorDisciplina> professoresDisciplinas;

	public List<ProfessorDisciplina> getProfessoresDisciplinas() {
		return professoresDisciplinas;
	}

	public void setProfessoresDisciplinas(List<ProfessorDisciplina> professoresDisciplinas) {
		this.professoresDisciplinas = professoresDisciplinas;
	}

}
