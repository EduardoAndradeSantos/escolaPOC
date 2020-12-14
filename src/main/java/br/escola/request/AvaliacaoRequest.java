package br.escola.request;

public class AvaliacaoRequest {
	private Long alunoId;
	private Long professorDisciplinaId;;
	private Double av1;
	private Double av2;

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public Long getProfessorDisciplinaId() {
		return professorDisciplinaId;
	}

	public void setProfessorDisciplinaId(Long professorDisciplinaId) {
		this.professorDisciplinaId = professorDisciplinaId;
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

}
