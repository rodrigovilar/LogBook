package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Pergunta;
import br.com.ufpb.aps.logbook.excecao.PerguntaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.PerguntaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.PerguntaSemDadosException;

public class GerenciadorPergunta {
	private List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
	public void adicionarPergunta(Pergunta novaPergunta)
			throws PerguntaSemDadosException, PerguntaJaCadastradaException {
		if (novaPergunta.getCodPergunta() == null
				|| novaPergunta.getPergunta() == null)
			throw new PerguntaSemDadosException(
					"Imposs�vel adicionar pergunta sem dados!");
		try {
			pesquisarPergunta(novaPergunta.getCodPergunta());
			throw new PerguntaJaCadastradaException(
					"J� existe pergunta cadastrada com o c�digo informado!");
		} catch (PerguntaInexistenteException e1) {
			listaPerguntas.add(novaPergunta);
		}
	}
	public Pergunta editarPergunta(Pergunta pergunta)
			throws PerguntaInexistenteException {
		Pergunta p = pesquisarPergunta(pergunta.getCodPergunta());
		p.setCodPergunta(pergunta.getCodPergunta());
		p.setPergunta(pergunta.getPergunta());
		return p;
	}
	public Pergunta pesquisarPergunta(String codPergunta)
			throws PerguntaInexistenteException {
		for (Pergunta p : listaPerguntas) {
			if (p.getCodPergunta().equals(codPergunta))
				;
			return p;
		}
		throw new PerguntaInexistenteException(
				"N�o existe esta pergunta no Sitema LogBook");
	}
	public void deletarPergunta(String codPergunta)
			throws PerguntaInexistenteException {
		Pergunta p = pesquisarPergunta(codPergunta);
		listaPerguntas.remove(p);
	}
	public List<Pergunta> getListPerguntas() {
		return listaPerguntas;
	}
	public void setListPerguntas(List<Pergunta> listPerguntas) {
		this.listaPerguntas = listPerguntas;
	}
}
