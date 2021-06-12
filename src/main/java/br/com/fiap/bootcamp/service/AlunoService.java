package br.com.fiap.bootcamp.service;

import java.util.List;

import br.com.fiap.bootcamp.dto.Aluno;
import br.com.fiap.bootcamp.dto.Login;

public interface AlunoService {

	List<Aluno> listaAluno();

	Aluno detalharAluno(Aluno aluno);
	
	Boolean autenticarAluno(Login login, Boolean auth);

	Aluno salvarAluno(Aluno aluno);

	Aluno editarAluno(Long id);

	void excluirAluno(Long id);
}
