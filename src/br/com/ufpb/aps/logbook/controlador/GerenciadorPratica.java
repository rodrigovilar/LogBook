package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.excecao.PraticaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.PraticaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.PraticaSemDadosException;

public class GerenciadorPratica {
	// private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	private List<Pratica> listaPraticas = new ArrayList<Pratica>();
	public void adicionarPraticaProfessor(Pratica novaPratica)
			throws PraticaSemDadosException, PraticaJaCadastradaException,
			PraticaInexistenteException {
		if (novaPratica.getNumeroPratica() == null)
			throw new PraticaSemDadosException("Pratica sem Dados");
		try {
			pesquisarPratica(novaPratica.getNumeroPratica());
			throw new PraticaJaCadastradaException("Pratica j� cadastrada");
		} catch (PraticaInexistenteException e) {
			listaPraticas.add(novaPratica);
		}
	}
	public Pratica editarPratica(Pratica pratica)
			throws PraticaInexistenteException {
		Pratica p = pesquisarPratica(pratica.getNumeroPratica());
		p.setNumeroPratica(pratica.getNumeroPratica());
		return p;
	}
	public Pratica pesquisarPratica(String numPratica)
			throws PraticaInexistenteException {
		for (Pratica p : listaPraticas) {
			if (p.getNumeroPratica().equals(numPratica)) {
				return p;
			}
		}
		throw new PraticaInexistenteException(
				"N�o existe est� pr�tica no Sitema LogBook");
	}
	public void deletarPratica(String numeroPratica)
			throws PraticaInexistenteException {
		Pratica p = pesquisarPratica(numeroPratica);
		listaPraticas.remove(p);
	}
	public List<Pratica> getPraticas() {
		return listaPraticas;
	}
	public void setPraticas(List<Pratica> praticas) {
		this.listaPraticas = praticas;
	}
}
