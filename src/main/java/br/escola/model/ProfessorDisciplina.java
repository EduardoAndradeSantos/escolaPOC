package br.escola.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProfessorDisciplina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "professor_Id")
	private Professor professor;

	@ManyToOne
	@JoinColumn(name = "disciplina_Id")
	private Disciplina disciplina;

	public ProfessorDisciplina() {

	}

	public ProfessorDisciplina(Long id) {
		super();
		this.id = id;
	}

	public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
		super();
		this.professor = professor;
		this.disciplina = disciplina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
