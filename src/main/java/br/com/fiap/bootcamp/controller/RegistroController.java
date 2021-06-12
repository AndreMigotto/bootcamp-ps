package br.com.fiap.bootcamp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.bootcamp.dto.Aluno;
import br.com.fiap.bootcamp.dto.Curso;
import br.com.fiap.bootcamp.dto.Professor;
import br.com.fiap.bootcamp.service.impl.AlunoServiceImpl;
import br.com.fiap.bootcamp.service.impl.CursoServiceImpl;
import br.com.fiap.bootcamp.service.impl.ProfessorServiceImpl;

@Controller
public class RegistroController {
	
	@Autowired
	AlunoServiceImpl serviceAluno;
	
	@Autowired
	ProfessorServiceImpl serviceProfessor;
	
	@Autowired
	CursoServiceImpl serviceCurso;
	
	@GetMapping("/novo-aluno")
	public ModelAndView inserirAluno() {
		ModelAndView view = new ModelAndView("form-aluno");
		List<Curso> cursos = serviceCurso.listaCurso();
		view.addObject("cursos", cursos);
		view.addObject(new Aluno());
		return view;
	}
	
	@GetMapping("/novo-professor")
	public ModelAndView inserirProfessor() {
		ModelAndView view = new ModelAndView("form-professor");
		List<Curso> cursos = serviceCurso.listaCurso();
		view.addObject("cursos", cursos);
		view.addObject(new Professor());
		return view;
	}
	
	@PostMapping("/salvar-aluno")
	public String salvarAluno(@Valid Aluno aluno, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(aluno);
			return "aluno";
		}
		serviceAluno.salvarAluno(aluno);
		return "redirect:/listar-alunos";
	}
	
	@PostMapping("/salvar-professor")
	public String salvarProfessor(@Valid Professor professor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(professor);
			return "professor";
		}
		serviceProfessor.salvarProfessor(professor);
		return "redirect:/listar-professores";
	}
	
	@GetMapping("/listar-alunos")
	public ModelAndView listaCadastro() {
		ModelAndView view = new ModelAndView("listar-alunos");
		List<Curso> cursos = serviceCurso.listaCurso();
		view.addObject("cursos", cursos);
		List<Aluno> alunos = serviceAluno.listaAluno();
		view.addObject("alunos", alunos);
		return view;
	}
	
	@GetMapping("/listar-professores")
	public ModelAndView listaProfessor() {
		ModelAndView view = new ModelAndView("listar-professores");
		List<Curso> cursos = serviceCurso.listaCurso();
		view.addObject("cursos", cursos);
		List<Professor> professores = serviceProfessor.listaProfessor();
		view.addObject("professores", professores);
		return view;
	}
	
	@GetMapping("/aluno/{id}")
	public ModelAndView editarAluno(@PathVariable Long id) {
		ModelAndView view = new ModelAndView("form-aluno");
		List<Curso> cursos = serviceCurso.listaCurso();
		view.addObject("cursos", cursos);
		Aluno aluno = serviceAluno.editarAluno(id);
		view.addObject("aluno", aluno);
		return view;
	}
	
	@GetMapping("/professor/{id}")
	public ModelAndView editarProfessor(@PathVariable Long id) {
		ModelAndView view = new ModelAndView("form-professor");
		List<Curso> cursos = serviceCurso.listaCurso();
		view.addObject("cursos", cursos);
		Professor professor = serviceProfessor.editarProfessor(id);
		view.addObject("professor", professor);
		return view;
	}

	@GetMapping("/aluno/excluir/{id}")
	public String excluirAluno(@PathVariable Long id) {
		serviceAluno.excluirAluno(id);
		return "redirect:/listar-alunos";
	}
	
	@GetMapping("/professor/excluir/{id}")
	public String excluirProfessor(@PathVariable Long id) {
		serviceProfessor.excluirProfessor(id);
		return "redirect:/listar-professores";
	}
}