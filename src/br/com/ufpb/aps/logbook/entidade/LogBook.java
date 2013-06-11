package br.com.ufpb.aps.logbook.entidade;

import javax.xml.crypto.Data;

public class LogBook {
	
	private String assunto;
	private Data data;
	private int hora;//Qual tipo de hora?
	private Disciplina disciplina;
	private Turma turma;
	private Pratica pratica;
	
	public LogBook(Data data, int hora, String assunto, Disciplina disciplina,
			Turma turma, Pratica pratica) {
	
		this.data = data;
		this.hora = hora;
		this.assunto = assunto;
		this.disciplina = disciplina;
		this.turma = turma;
		this.pratica = pratica;
	}
	
	public LogBook(){
		
	}
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
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
	public Pratica getPratica() {
		return pratica;
	}
	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}
	
	public String toString() {
		return "Assundo da Aula: " + this.getAssunto() + ""; 
	}
}
