package br.escola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.escola.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	DisciplinaRepository _repository;

}
