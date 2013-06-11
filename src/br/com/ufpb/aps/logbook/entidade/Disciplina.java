package br.com.ufpb.aps.logbook.entidade;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {

	private String nomeDisciplina;
	private String codigoDisciplina;

	private List<Turma> turmas = new ArrayList<Turma>();

	public Disciplina(String nomeDisciplina, String codigoDisciplina,
			Professor professor, List<Turma> turmas) {
		this.nomeDisciplina = nomeDisciplina;
		this.codigoDisciplina = codigoDisciplina;
		this.turmas = turmas;
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

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public String toString() {
		return "Disciplina: " + this.getNomeDisciplina()
				+ "Código da Disciplina: " + this.getCodigoDisciplina()
				+ "Turmas: " + this.getTurmas();
	}
}
