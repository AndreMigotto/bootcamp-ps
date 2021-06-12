package br.com.fiap.bootcamp.dto;

import javax.validation.constraints.NotBlank;

public class Aluno {

	private Long id;
	private String nomeAluno;
	@NotBlank
	private String emailAluno;
	@NotBlank
	private String senhaAluno;
	private String cpfAluno;
	private String nascimentoAluno;
	private Curso curso;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getNascimentoAluno() {
		return nascimentoAluno;
	}

	public void setNascimentoAluno(String nascimentoAluno) {
		this.nascimentoAluno = nascimentoAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getSenhaAluno() {
		return senhaAluno;
	}

	public void setSenhaAluno(String senhaAluno) {
		this.senhaAluno = senhaAluno;
	}
}
