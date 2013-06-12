package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorProfessor {

	//private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	//private List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	
	private List<Professor> listaProfessores = new ArrayList<Professor>();

	public void adicionarProfessor(Professor professor) {
		listaProfessores.add(professor);
	}

	public Professor pesquisarProfessor(String codigo) {
		for (Professor p : listaProfessores) {
			if (p.getCodigo().equalsIgnoreCase(codigo))
				;
			return p;

		}
		throw new Excecao(
				"Não existe este aluno com esta matricula no Sitema LogBook");
	}

	public Professor editarProfessor(Professor professor) {
		for (Professor p : listaProfessores) {
			if (professor.getCodigo().equals(p.getCodigo())) {
				p = professor;
				listaProfessores.add(p);
				return p;
			}
		}
		throw new Excecao(
				"Não existe Professor com este código no sistema LogBook");
	}

	public List<Professor> listaTodosProfessores() {
		return listaProfessores;

	}

	public void deletarProfessor(String codigo) {
		for (Professor p : listaProfessores) {

			if (p.getCodigo().equalsIgnoreCase(codigo)) {
				listaProfessores.remove(p);				
				return;
			}
		}
	}
	
}
