package br.com.fiap.bootcamp.service;

import java.util.List;

import br.com.fiap.bootcamp.dto.Professor;

public interface ProfessorService {

	List<Professor> listaProfessor();

	Professor detalharProfessor(Professor professor);

	Professor salvarProfessor(Professor professor);

	Professor editarProfessor(Long id);

	void excluirProfessor(Long id);
}
