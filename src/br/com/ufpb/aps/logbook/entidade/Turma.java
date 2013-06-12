package br.com.ufpb.aps.logbook.entidade;

import java.util.List;

public class Turma {

	private String codigoTurma;
	private List<Aluno> alunos;
	private Professor professore;
	private List<Disciplina> disciplinas;

	public Turma(String codigo, List<Aluno> alunos,	Professor professores, List<Disciplina> disciplinas) {
		this.professore = professores;
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

	public Professor getProfessores() {
		return professore;
	}

	public void setProfessores(Professor professore) {
		this.professore = professore;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
