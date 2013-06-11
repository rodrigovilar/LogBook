package br.com.ufpb.aps.logbook.controlador;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.entidade.Turma;
import br.com.ufpb.aps.logbook.excecao.Excecao;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorProfessor {

	private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	private List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
	private List<Professor> listaProfessores = new ArrayList<Professor>();

	public void adicionarProfessor(Professor professor) {
		listaProfessores.add(professor);
	}

	public Professor pesquisarProfessor(String codigo) {
		Professor professor = new Professor();
		for (Professor p : listaProfessores) {
			if (p.getCodigo() == codigo) {
				professor = p;
				break;
			}
		}
		return professor;
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
			}
		}
	}
}
