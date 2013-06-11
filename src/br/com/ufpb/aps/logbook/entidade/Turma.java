package br.com.ufpb.aps.logbook.entidade;

import java.util.List;

public class Turma {

	private String codigoTurma;
	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<Disciplina> disciplinas;

	public Turma(String codigo, List<Aluno> alunos,
			List<Professor> professores, List<Disciplina> disciplinas) {
		this.professores = professores;
		this.disciplinas = disciplinas;
		this.codigoTurma = codigo;
		this.alunos = alunos;
	}

	public Turma() {

	}

	public String getCodigo() {
		return codigoTurma;
	}

	public void setCodigo(String codigo) {
		this.codigoTurma = codigo;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
