package br.com.ufpb.aps.logbook.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

public class LogBook {
	
	private String assunto;
	private Data data;
	private String hora;
	private Professor professor;
	private Disciplina disciplina;
	private Turma turma;
	
	private List<Pratica> listaPratica = new ArrayList<Pratica>();
	private List<Pergunta> listaPergunta = new ArrayList<Pergunta>();
	private List<Resposta> listaResposta = new ArrayList<Resposta>();
	
	public LogBook(Data data, String hora, String assunto, Disciplina disciplina,
			Turma turma) {
	
		this.data = data;
		this.hora = hora;
		this.assunto = assunto;
		this.disciplina = disciplina;
		this.turma = turma;
	}
	
	public LogBook(){
		
	}
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Pratica> getListaPratica() {
		return listaPratica;
	}

	public void setListaPratica(List<Pratica> listaPratica) {
		this.listaPratica = listaPratica;
	}

	public List<Pergunta> getListaPergunta() {
		return listaPergunta;
	}

	public void setListaPergunta(List<Pergunta> listaPergunta) {
		this.listaPergunta = listaPergunta;
	}

	public List<Resposta> getListaResposta() {
		return listaResposta;
	}

	public void setListaResposta(List<Resposta> listaResposta) {
		this.listaResposta = listaResposta;
	}
	
	//TODO: Falta continuar
	public String toString() {
		return "LogBook do Dia " + this.getAssunto() + ""; 
	}
}
