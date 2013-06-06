package br.com.ufpb.aps.logbok.entidade;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private Professor professor;
	private Aluno aluno;
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public Disciplina(Professor professor, Aluno aluno, List<Turma> turmas) {
		
		this.professor = professor;
		this.aluno = aluno;
		this.turmas = turmas;
	}
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	public Disciplina (Professor professor, Aluno aluno){
		this.professor = professor;
		this.aluno = aluno;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	public Disciplina obterNomeDisciplina(Disciplina disciplina){
		return null;
	}
}
