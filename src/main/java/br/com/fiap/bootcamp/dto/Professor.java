package br.com.fiap.bootcamp.dto;

import javax.validation.constraints.NotBlank;

public class Professor {

	private long id;
	private String nomeProfessor;
	@NotBlank
	private String emailProfessor;
	@NotBlank
	private String senhaProfessor;
	private String cpfProfessor;
	private String nascimentoProfessor;
	private Curso curso;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getCpfProfessor() {
		return cpfProfessor;
	}

	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}

	public String getNascimentoProfessor() {
		return nascimentoProfessor;
	}

	public void setNascimentoProfessor(String nascimentoProfessor) {
		this.nascimentoProfessor = nascimentoProfessor;
	}

	public String getEmailProfessor() {
		return emailProfessor;
	}

	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}

	public String getSenhaProfessor() {
		return senhaProfessor;
	}

	public void setSenhaProfessor(String senhaProfessor) {
		this.senhaProfessor = senhaProfessor;
	}
}
