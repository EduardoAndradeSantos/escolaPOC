package br.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.escola.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository _repository;

}
