package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Pergunta;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorPergunta {

	private List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();

	public Pergunta editarPergunta(Pergunta pergunta) {

		for (Pergunta p : listaPerguntas) {
			if (p.getCodPergunta().equals(pergunta.getCodPergunta())) {
				p = pergunta;
				listaPerguntas.add(p);
				return p;
			}
		}
		throw new Excecao("Não existe esta pergunta no Sitema LogBook");
	}

	public Pergunta pesquisarPergunta(String codPergunta) {
		for (Pergunta p : listaPerguntas) {
			if(p.getCodPergunta().equalsIgnoreCase(codPergunta));
				return p;
		}
		throw new Excecao("Não existe esta pergunta no Sitema LogBook");
	}

	public void deletarPergunta(String codPergunta) {
		Pergunta pergunta = new Pergunta();
		pergunta = this.pesquisarPergunta(codPergunta);
		
		if (pergunta.getCodPergunta() == codPergunta){
			this.listaPerguntas.remove(pergunta);
		}
	}

	public List<Pergunta> getListPerguntas() {
		return listaPerguntas;
	}

	public void setListPerguntas(List<Pergunta> listPerguntas) {
		this.listaPerguntas = listPerguntas;
	}

	public void adicionarPergunta(Pergunta novaPergunta) {
		listaPerguntas.add(novaPergunta);
	}
}
