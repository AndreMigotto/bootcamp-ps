package br.com.fiap.bootcamp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.bootcamp.dto.Aluno;
import br.com.fiap.bootcamp.dto.Login;
import br.com.fiap.bootcamp.entity.AlunoEntity;
import br.com.fiap.bootcamp.entity.CursoEntity;
import br.com.fiap.bootcamp.repository.AlunoRepository;
import br.com.fiap.bootcamp.repository.CursoRepository;
import br.com.fiap.bootcamp.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository repositoryAluno;
	
	@Autowired
	private CursoRepository repositoryCurso;
	
	@Override
	public List<Aluno> listaAluno() {
		List<AlunoEntity> lista = repositoryAluno.findAll();
		List<Aluno> valor = fromTo(lista);
		return valor;
	}

	@Override
	public Aluno detalharAluno(Aluno aluno) {
		return null;
	}

	@Override
	public Aluno salvarAluno(Aluno aluno) {
		AlunoEntity entity = fromTo(aluno); 
		CursoEntity cursoEntity = repositoryCurso.findById(aluno.getCurso().getId()).get();
		entity.setCurso(cursoEntity);
		entity = repositoryAluno.save(entity);
		Aluno alunoRetorno = fromTo(entity);
		return alunoRetorno;
	}

	@Override
	public Aluno editarAluno(Long id) {
		AlunoEntity entity = repositoryAluno.findById(id).get();
		return fromTo(entity);
	}

	@Override
	public void excluirAluno(Long id) {
		repositoryAluno.deleteById(id);
	}
	
	private AlunoEntity fromTo(Aluno aluno) {
		AlunoEntity entity = new AlunoEntity();
		entity.setId(aluno.getId());
		entity.setCpfAluno(aluno.getCpfAluno());
		entity.setNomeAluno(aluno.getNomeAluno());
		entity.setEmailAluno(aluno.getEmailAluno());
		entity.setNascimentoAluno(aluno.getNascimentoAluno());
		entity.setSenhaAluno(aluno.getSenhaAluno());
		return entity;
	}

	private Aluno fromTo(AlunoEntity entity) {
		Aluno aluno = new Aluno();
		aluno.setId(entity.getId());
		aluno.setCpfAluno(entity.getCpfAluno());
		aluno.setNomeAluno(entity.getNomeAluno());
		aluno.setEmailAluno(entity.getEmailAluno());
		aluno.setNascimentoAluno(entity.getNascimentoAluno());
		aluno.setSenhaAluno(entity.getSenhaAluno());
		return aluno;
	}

	private List<Aluno> fromTo(List<AlunoEntity> lista) {
		List<Aluno> listaDto = new ArrayList<>();
		for (AlunoEntity alunoEntity : lista) {
			Aluno dto = new Aluno();
			dto.setId(alunoEntity.getId());
			dto.setCpfAluno(alunoEntity.getCpfAluno());
			dto.setNomeAluno(alunoEntity.getNomeAluno());
			dto.setEmailAluno(alunoEntity.getEmailAluno());
			dto.setNascimentoAluno(alunoEntity.getNascimentoAluno());
			dto.setSenhaAluno(alunoEntity.getSenhaAluno());
			listaDto.add(dto);
		}
		return listaDto;
	}

	@Override
	public Boolean autenticarAluno(Login login, Boolean auth) {
		List<AlunoEntity> lista = repositoryAluno.findAll();
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getEmailAluno().equals(login.getEmail()) && lista.get(i).getSenhaAluno().equals(login.getSenha())) {
				return true;
			}else {
				return false;
			}
		}
		return auth;
	}
}
