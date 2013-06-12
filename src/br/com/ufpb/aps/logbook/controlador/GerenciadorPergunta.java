package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Pergunta;
import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorPergunta {

	private List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();

	public List<Pergunta> getListPerguntas() {
		return listaPerguntas;
	}

	public void setListPerguntas(List<Pergunta> listPerguntas) {
		this.listaPerguntas = listPerguntas;
	}
	
	public void adicionarPergunta(Pergunta novaPergunta) {
		listaPerguntas.add(novaPergunta);
	}
	
	public Pergunta editarPergunta(Pergunta pergunta) {

		for (Pergunta p : listaPerguntas) {
			if (p.getCodPergunta().equals(pergunta.getCodPergunta())) {
				p = pergunta;
				listaPerguntas.add(p);
				return p;
			}
		}
		throw new Excecao(
				"Não existe esta pergunta no Sitema LogBook");
	}

	
	public Pergunta pesquisarPergunta(String pergunta) {
		for (Pergunta d : listaPerguntas) {
			if (d.getCodPergunta().equalsIgnoreCase(pergunta)) {
				
			}
				return d;
			}
	
	throw new Excecao(
			"Não existe esta pergunta no Sitema LogBook");
	}
	
	public void deletarPergunta(String codPergunta) {
		for (Pergunta d : listaPerguntas) {
			if (d.getCodPergunta().equalsIgnoreCase(codPergunta)) {
				listaPerguntas.remove(d);
				return;
			}

		}
		throw new Excecao(
				"Não existe esta pergunta no Sitema LogBook");
	}
	
	
}
