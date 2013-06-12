package br.com.ufpb.aps.logbook.entidade;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

	private String nomeDisciplina;
	private String codigoDisciplina;
	private Pratica pratica;
	private Professor professor;

	private List<Turma> listaTurmas = new ArrayList<Turma>();
	private List<Pratica> listaPraticas = new ArrayList<Pratica>();

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

	public List<Pratica> getPraticas() {
		return listaPraticas;
	}

	public void setPraticas(List<Pratica> praticas) {
		this.listaPraticas = praticas;
	}
	
	public List<Pratica> getListaPraticas() {
		return listaPraticas;
	}

	public void setListaPraticas(List<Pratica> listaPraticas) {
		this.listaPraticas = listaPraticas;
	}
	
	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
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
