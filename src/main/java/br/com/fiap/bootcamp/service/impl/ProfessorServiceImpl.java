package br.com.fiap.bootcamp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.bootcamp.dto.Professor;
import br.com.fiap.bootcamp.entity.CursoEntity;
import br.com.fiap.bootcamp.entity.ProfessorEntity;
import br.com.fiap.bootcamp.repository.CursoRepository;
import br.com.fiap.bootcamp.repository.ProfessorRepository;
import br.com.fiap.bootcamp.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	@Autowired
	private ProfessorRepository repositoryProfessor;
	
	@Autowired
	private CursoRepository repositoryCurso;

	@Override
	public List<Professor> listaProfessor() {
		List<ProfessorEntity> lista = repositoryProfessor.findAll();
		List<Professor> professor = fromTo(lista);
		return professor;
	}

	@Override
	public Professor detalharProfessor(Professor professor) {
		return null;
	}

	@Override
	public Professor salvarProfessor(Professor professor) {
		ProfessorEntity entity = fromTo(professor); 
		CursoEntity cursoEntity = repositoryCurso.findById(professor.getCurso().getId()).get();
		entity.setCurso(cursoEntity);
		entity = repositoryProfessor.save(entity);
		Professor professorRetorno = fromTo(entity);
		return professorRetorno;
	}

	@Override
	public Professor editarProfessor(Long id) {
		ProfessorEntity entity = repositoryProfessor.findById(id).get();
		return fromTo(entity);
	}

	@Override
	public void excluirProfessor(Long id) {
		repositoryProfessor.deleteById(id);
		
	}
	
	private ProfessorEntity fromTo(Professor professor) {
		ProfessorEntity entity = new ProfessorEntity();
		entity.setId(professor.getId());
		entity.setCpfProfessor(professor.getCpfProfessor());
		entity.setNomeProfessor(professor.getNomeProfessor());
		entity.setEmailProfessor(professor.getEmailProfessor());
		entity.setNascimentoProfessor(professor.getNascimentoProfessor());
		entity.setSenhaProfessor(professor.getSenhaProfessor());
		return entity;
	}

	private Professor fromTo(ProfessorEntity entity) {
		Professor professor = new Professor();
		professor.setId(entity.getId());
		professor.setCpfProfessor(entity.getCpfProfessor());
		professor.setNomeProfessor(entity.getNomeProfessor());
		professor.setEmailProfessor(entity.getEmailProfessor());
		professor.setNascimentoProfessor(entity.getNascimentoProfessor());
		professor.setSenhaProfessor(entity.getSenhaProfessor());
		return professor;
	}

	private List<Professor> fromTo(List<ProfessorEntity> lista) {
		List<Professor> listaDto = new ArrayList<>();
		for (ProfessorEntity professorEntity : lista) {
			Professor dto = new Professor();
			dto.setId(professorEntity.getId());
			dto.setCpfProfessor(professorEntity.getCpfProfessor());
			dto.setNomeProfessor(professorEntity.getNomeProfessor());
			dto.setEmailProfessor(professorEntity.getEmailProfessor());
			dto.setNascimentoProfessor(professorEntity.getNascimentoProfessor());
			dto.setSenhaProfessor(professorEntity.getSenhaProfessor());
			listaDto.add(dto);
		}
		return listaDto;
	}
}
