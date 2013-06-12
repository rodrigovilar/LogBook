package br.com.ufpb.aps.logbook.entidade;

import java.util.ArrayList;

public class Disciplina {

	private String nomeDisciplina;
	private String codigoDisciplina;
	private Pratica pratica;
	private Professor professor;

	private ArrayList<Turma> listaTurmas = new ArrayList<Turma>();
	private ArrayList<Pratica> listaPraticas = new ArrayList<Pratica>();

	public Disciplina(String nomeDisciplina, String codigoDisciplina, Pratica pratica, Professor professor) {
		this.nomeDisciplina = nomeDisciplina;
		this.codigoDisciplina = codigoDisciplina;
		this.pratica = pratica;
		this.setProfessor(professor);
	}
	
	public Disciplina(){
		
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String toString() {
		return "Disciplina: " + this.getNomeDisciplina()
				+ "Código da Disciplina: " + this.getCodigoDisciplina()
				+ "Turmas: " + this.getListaTurmas();
	}

	public ArrayList<Pratica> getPraticas() {
		return listaPraticas;
	}

	public void setPraticas(ArrayList<Pratica> praticas) {
		this.listaPraticas = praticas;
	}
	
	public ArrayList<Pratica> getListaPraticas() {
		return listaPraticas;
	}

	public void setListaPraticas(ArrayList<Pratica> listaPraticas) {
		this.listaPraticas = listaPraticas;
	}
	
	public ArrayList<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(ArrayList<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}

	public Pratica getPratica() {
		return pratica;
	}

	public void setPratica(Pratica pratica) {
		this.pratica = pratica;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
