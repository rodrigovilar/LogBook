package br.com.ufpb.aps.logbok.entidade;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario{	
	
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Disciplina> disciplina;
	
 public Professor(String nome, String email, String senha, String login,
			String sobrenome, String confirmaSenha) {
		super(nome, email, senha, login, sobrenome, confirmaSenha);
		// TODO Auto-generated constructor stub
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
