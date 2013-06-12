package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;

import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorAluno extends Exception {

	private List<Aluno> listaTodosAlunos = new ArrayList<Aluno>();

	public void adicionarAluno(Aluno aluno) {
		listaTodosAlunos.add(aluno);
	}

	public Aluno pesquisarAluno(String matricula) {
		for (Aluno aluno : listaTodosAlunos) {
			if (aluno.getMatricula().equals(matricula))
				;
			return aluno;
		}
		throw new Excecao(
				"Não existe este aluno com esta matricula no Sitema LogBook");
	}

	public Aluno EditarDadosAluno(Aluno aluno) {
		for (Aluno a : listaTodosAlunos) {
			if (aluno.getMatricula().equals(a.getMatricula())) {
				a.setEmail(aluno.getEmail());
				a.setLogin(aluno.getLogin());
				a.setNome(aluno.getNome());
				a.setSobrenome(aluno.getSobrenome());
				a.setSenha(aluno.getSenha());
				a.setMatricula(aluno.getMatricula());
				return a;
			}
		}
		throw new Excecao(
				"Não existe aluno com esta matricula no Sitema LogBook");
	}

	public void deletarAluno(String matricula) {
		
		for (Aluno b : listaTodosAlunos) {		

			if (b.getMatricula().equalsIgnoreCase(matricula)) {
				listaTodosAlunos.remove(b);	
				return;
			}
		}
	}

	public String listarAlunos() {
		return listaTodosAlunos.toString();
	}

	public List<Aluno> getListaTodosAlunos() {
		return listaTodosAlunos;
	}

	public void setListaTodosAlunos(List<Aluno> listaTodosAlunos) {
		this.listaTodosAlunos = listaTodosAlunos;
	}

}