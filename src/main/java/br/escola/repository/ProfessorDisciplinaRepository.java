package br.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.escola.model.ProfessorDisciplina;

@Repository
public interface ProfessorDisciplinaRepository extends JpaRepository<ProfessorDisciplina, Long> {

}
