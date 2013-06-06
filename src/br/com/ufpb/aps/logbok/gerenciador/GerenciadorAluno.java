package br.com.ufpb.aps.logbok.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbok.entidade.Aluno;

public class GerenciadorAluno {

	private List<Aluno> Alunos = new ArrayList<Aluno>();
	
	public void adicionarAluno(Aluno alunos){
		
	}
	
	public void editarAluno(List<Aluno> aluno){
		
	}
	public List<Aluno> listaTodosAlunos(){
		return Alunos;
		
	}
	public List<Aluno> pesquisarAluno(List<Aluno> aluno){
		return aluno;
		
	}
	public List<Aluno> deletarAluno(String nome){
		return Alunos;
		
	}
}
