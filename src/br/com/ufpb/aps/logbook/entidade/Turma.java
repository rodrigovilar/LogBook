package br.com.ufpb.aps.logbook.entidade;

import java.util.List;

public class Turma {
	private String codigoTurma;
	private String anoDaTurma;
	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<Disciplina> disciplinas;
	public Turma(String codigo, String anoDaTurma, List<Aluno> alunos,
			List<Professor> professores, List<Disciplina> disciplinas) {
		this.professores = professores;
		this.disciplinas = disciplinas;
		this.codigoTurma = codigo;
		this.anoDaTurma = anoDaTurma;
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
	public void setProfessores(List<Professor> professor) {
		this.professores = professor;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String getAnoDaTurma() {
		return anoDaTurma;
	}
	public void setAnoDaTurma(String anoDaTurma) {
		this.anoDaTurma = anoDaTurma;
	}
}
