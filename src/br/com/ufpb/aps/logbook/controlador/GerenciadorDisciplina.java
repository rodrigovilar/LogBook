package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Turma;
import br.com.ufpb.aps.logbook.excecao.Excecao;

//import br.com.ufpb.aps.logbok.entidade.Aluno;

public class GerenciadorDisciplina {

	private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	private List<Turma> listaTurmas = new ArrayList<Turma>();

	public void adicionarDisciplina(Disciplina disciplina) {
		listaDisciplinas.add(disciplina);
	}

	public Disciplina editarDisciplina(Disciplina disciplina) {
		for (Disciplina d : listaDisciplinas) {
			if (disciplina.getCodigoDisciplina()
					.equals(d.getCodigoDisciplina())) {
				d = disciplina;
				listaDisciplinas.add(d);
				return d;
			}
		}
		throw new Excecao(
				"Não existe está Disciplina com este código no sistema LogBook");
	}

	public List<Disciplina> listaDisciplinas() {
		return listaDisciplinas;

	}

	public Disciplina pesquisarDisciplina(String codigoDisciplina) {
		Disciplina disciplina = new Disciplina();
		for (Disciplina d : listaDisciplinas) {
			if (d.getCodigoDisciplina() == codigoDisciplina)
				disciplina = d;
			break;
		}
		return disciplina;
	}

	public void deletarDisciplina(String codigoDisciplina) {
		Disciplina disciplina = new Disciplina();
		disciplina = this.pesquisarDisciplina(codigoDisciplina);
		
		if (disciplina.getCodigoDisciplina() == codigoDisciplina){
			this.listaDisciplinas.remove(disciplina);
		}
		//listaDisciplinas.remove(codigoDisciplina);
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
}
