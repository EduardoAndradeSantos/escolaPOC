package br.escola.response;

import java.util.List;

import br.escola.model.Disciplina;

public class ListDisciplinaResponse extends BaseResponse {

	public List<Disciplina> disciplinas;

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
