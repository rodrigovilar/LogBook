package br.com.ufpb.aps.logbok.entidade;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private String codigo;
	private List<Aluno> alunos;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public Turma(String codigo, List<Aluno> alunos) {
		
		this.codigo = codigo;
		this.alunos = new ArrayList<Aluno>();
	}

}
