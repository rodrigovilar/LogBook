package br.com.ufpb.aps.logbook.entidade;

import java.util.ArrayList;
import java.util.List;

public class Pratica {
	private String numeroPratica;
	private Disciplina disciplina;
	private List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
	public Pratica(List<Pergunta> perguntas, Disciplina disciplina) {
		this.setPergunta(perguntas);
		this.setDisciplina(disciplina);
	}
	public Pratica() {
	}
	public String getNumeroPratica() {
		return numeroPratica;
	}
	public void setNumeroPratica(String numeroPratica) {
		this.numeroPratica = numeroPratica;
	}
	public List<Pergunta> getListaPerguntas() {
		return listaPerguntas;
	}
	public void setListaPerguntas(List<Pergunta> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}
	public List<Pergunta> getPergunta() {
		return listaPerguntas;
	}
	public void setPergunta(List<Pergunta> pergunta) {
		this.listaPerguntas = pergunta;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
