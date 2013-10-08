package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Turma;
import br.com.ufpb.aps.logbook.excecao.DisciplinaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.DisciplinaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.DisciplinaSemDadosException;
import br.com.ufpb.aps.logbook.persistencia.Persistencia;

public class GerenciadorDisciplina {

	private List<Disciplina> listaDisciplinas;
	private List<Turma> listaTurmas;
	private Persistencia<Disciplina> persistencia;

	public GerenciadorDisciplina() {
		persistencia = new Persistencia<Disciplina>("disciplinas.txt");
		listaDisciplinas = new ArrayList<Disciplina>();
		listaTurmas = new ArrayList<Turma>();
	}

	public void adicionarDisciplina(Disciplina disciplina)
			throws DisciplinaSemDadosException, DisciplinaJaCadastradaException {
		if (disciplina.getCodigoDisciplina() == null
				|| disciplina.getNomeDisciplina() == null
				|| disciplina.getProfessor() == null)
			throw new DisciplinaSemDadosException("Disciplina sem Dados");

		try {
			pesquisarDisciplina(disciplina.getCodigoDisciplina());
			throw new DisciplinaJaCadastradaException(
					"Disciplina j? cadastrada");
		}

		catch (DisciplinaInexistenteException e) {
			listaDisciplinas.add(disciplina);
			persistencia.save(listaDisciplinas);
		}
	}

	public Disciplina editarDisciplina(Disciplina disciplina)
			throws DisciplinaInexistenteException {
		Disciplina d = pesquisarDisciplina(disciplina.getCodigoDisciplina());
		d.setCodigoDisciplina(disciplina.getCodigoDisciplina());
		persistencia.save(listaDisciplinas);
		return d;
	}

	public Disciplina pesquisarDisciplina(String codigoDisciplina)
			throws DisciplinaInexistenteException {
		for (Disciplina d : listaDisciplinas) {
			if (d.getCodigoDisciplina() == codigoDisciplina) {
				return d;
			}
		}

		throw new DisciplinaInexistenteException(
				"A disciplina n?o foi encontrada no sistema");
	}

	public void deletarDisciplina(String codigoDisciplina)
			throws DisciplinaInexistenteException {
		Disciplina d = pesquisarDisciplina(codigoDisciplina);
		listaDisciplinas.remove(d);
		persistencia.save(listaDisciplinas);
	}

	public List<Disciplina> listaDisciplinas() {
		return listaDisciplinas;
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
