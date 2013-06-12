package br.com.ufpb.aps.logbook.entidade;

import java.util.ArrayList;

public class Pratica {
	
	private String pergunta;
	private Disciplina disciplina;
	
	private ArrayList<Resposta> listaResposta = new ArrayList<Resposta>();
	
	public Pratica (String pergunta, Disciplina disciplina){
		this.setPergunta(pergunta);
		this.setDisciplina(disciplina);
	}
	
	public Pratica(){
		
	}
	
	
	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public ArrayList<Resposta> getListaResposta() {
		return listaResposta;
	}

	public void setListaResposta(ArrayList<Resposta> listaResposta) {
		this.listaResposta = listaResposta;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
