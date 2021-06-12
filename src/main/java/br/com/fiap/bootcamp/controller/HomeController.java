package br.com.fiap.bootcamp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.bootcamp.dto.Aluno;
import br.com.fiap.bootcamp.dto.Login;
import br.com.fiap.bootcamp.service.impl.AlunoServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	AlunoServiceImpl serviceAluno;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView view = new ModelAndView("login");
		Login login = new Login();
		view.addObject("login", login);
		return view;
	}
	
	@PostMapping("/validar-aluno")
	public String salvarAluno(@Valid Login login, BindingResult result, Model model) {
		Boolean auth = false;
		auth = serviceAluno.autenticarAluno(login, auth);
		if(auth == true) {
			return "redirect:/sucesso";
		}else {
			return "redirect:/falha";
		}
	}
	
	@GetMapping("/sucesso")
	public ModelAndView homeSucesso() {
		ModelAndView view = new ModelAndView("home");
		return view;
	}
	
	@GetMapping("/falha")
	public ModelAndView homeError() {
		ModelAndView view = new ModelAndView("falha");
		return view;
	}
}
