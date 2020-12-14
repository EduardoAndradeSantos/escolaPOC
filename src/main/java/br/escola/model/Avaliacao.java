package br.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "professorDisciplina_id")
	private ProfessorDisciplina professorDisciplina;

	private Double av1;
	private Double av2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ProfessorDisciplina getProfessorDisciplina() {
		return professorDisciplina;
	}

	public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
		this.professorDisciplina = professorDisciplina;
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
