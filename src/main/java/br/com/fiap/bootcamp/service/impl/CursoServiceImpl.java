package br.com.fiap.bootcamp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.bootcamp.dto.Curso;
import br.com.fiap.bootcamp.entity.CursoEntity;
import br.com.fiap.bootcamp.repository.CursoRepository;
import br.com.fiap.bootcamp.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	@Override
	public List<Curso> listaCurso() {
		List<CursoEntity> listaCursoEntity = repository.findAll();
		List<Curso> listaCategoria = fromToCurso(listaCursoEntity);

		return listaCategoria;
	}
	
	private List<Curso> fromToCurso(List<CursoEntity> listaCursoEntity) {

		List<Curso> listaCurso = new ArrayList<>();

		for (CursoEntity cursoEntity : listaCursoEntity) {
			Curso curso = new Curso();
			curso.setId(cursoEntity.getId());
			curso.setNomeCurso(cursoEntity.getNomeCurso());
			listaCurso.add(curso);
		}
		return listaCurso;
	}
}
