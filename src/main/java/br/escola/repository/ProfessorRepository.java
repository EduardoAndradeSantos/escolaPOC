package br.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.escola.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
