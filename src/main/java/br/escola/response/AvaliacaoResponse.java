package br.escola.response;

import br.escola.model.Aluno;

public class AvaliacaoResponse extends BaseResponse {
	public Long id;
	public AlunoResponse aluno;
	public ProfessorResponse professor;
	public DisciplinaResponse disciplina;
	public Double av1;
	public Double av2;
	public String situacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AlunoResponse getAluno() {
		return aluno;
	}
	public void setAluno(AlunoResponse aluno) {
		this.aluno = aluno;
	}
	public ProfessorResponse getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorResponse professor) {
		this.professor = professor;
	}
	public DisciplinaResponse getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaResponse disciplina) {
		this.disciplina = disciplina;
	}
	public Double getAv1() {
		return av1;
	}
	public void setAv1(Double av1) {
		this.av1 = av1;
	}
	public Double getAv2() {
		return av2;
	}
	public void setAv2(Double av2) {
		this.av2 = av2;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
