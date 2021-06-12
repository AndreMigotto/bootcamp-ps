package br.com.fiap.bootcamp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_curso")
public class CursoEntity {

	@Id
	@Column(name = "ID_CURSO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_SEQ")
	@SequenceGenerator(name = "CURSO_SEQ", sequenceName = "CURSO_SEQ", allocationSize = 1)
	private long id;
	private String nomeCurso;

	@OneToMany(mappedBy = "curso")
	private List<AlunoEntity> alunos;

	@OneToMany(mappedBy = "curso")
	private List<ProfessorEntity> professores;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = alunos;
	}

	public List<ProfessorEntity> getProfessores() {
		return professores;
	}

	public void setProfessores(List<ProfessorEntity> professores) {
		this.professores = professores;
	}
}
