package br.com.ufpb.aps.logbook.entidade;

import java.util.List;

public class Professor extends Usuario {

	private String codigo;
	private Disciplina disciplina;

	public Professor(String nome, String sobrenome, String email, String senha,
			String login, String codigo, Disciplina disciplina) {
		super(nome, sobrenome, email, senha, login, codigo);
		this.codigo = codigo;
		this.setDisciplina(disciplina);
	}

	public Professor() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return "Nome do Professor: " + this.getNome()
				+ "Sobrenome do Professor: " + this.getSobrenome() + "E-mail: "
				+ this.getSenha() + "Login: " + this.getLogin()
				+ "Códido do Professor: " + this.getCodigo();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
