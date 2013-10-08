package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Turma;
import br.com.ufpb.aps.logbook.excecao.TurmaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.TurmaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.TurmaSemDadosException;

public class GerenciadorTurma {

	private List<Turma> listaTurmas = new ArrayList<Turma>();

	public void adicionarTurma(Turma novaTurma) throws TurmaSemDadosException,
			TurmaJaCadastradaException, TurmaInexistenteException {
		if (novaTurma.getCodigo() == null || novaTurma.getAnoDaTurma() == null
				|| novaTurma.getDisciplinas() == null
				|| novaTurma.getProfessores() == null
				|| novaTurma.getAlunos() == null)

			throw new TurmaSemDadosException("Turma sem Dados");

		try {
			pesquisarTurma(novaTurma.getCodigo());
			throw new TurmaJaCadastradaException(
					"O c�digo desta turma j� foi cadastrado no Sistema");
		} catch (TurmaInexistenteException e) {
			listaTurmas.add(novaTurma);
		}
	}

	public Turma editarTurma(Turma turma) throws TurmaInexistenteException {
		Turma t = pesquisarTurma(turma.getCodigo());
		t.setCodigo(turma.getCodigo());
		return t;
	}

	public Turma pesquisarTurma(String codigoTurma)
			throws TurmaInexistenteException {
		for (Turma t : listaTurmas) {
			if (t.getCodigo().equals(codigoTurma)) {
				return t;
			}
		}

		throw new TurmaInexistenteException(
				"A turma n�o foi encontrada no sistema");
	}

	public void deletarTurma(String codigoTurma)
			throws TurmaInexistenteException {
		Turma t = pesquisarTurma(codigoTurma);
		listaTurmas.remove(t);
	}

	public List<Turma> listaTodasTurma() {
		return getListaTurmas();

	}

	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

}
