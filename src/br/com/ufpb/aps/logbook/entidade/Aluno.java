package br.com.ufpb.aps.logbook.entidade;

import java.util.ArrayList;

public class Aluno extends Usuario {

	private String matricula;
	
	private ArrayList<Resposta> listaResposta = new ArrayList<Resposta>(); 
	private ArrayList<Turma> listaTurmas = new ArrayList<Turma>();

	public Aluno(String nome, String sobrenome, String email, String senha,
			String login, String matricula) {
		super(nome, sobrenome, email, senha, login);
		this.matricula = matricula;
	}

	public Aluno() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String toString() {
		return "Nome: " + this.getNome() + "Sobrenome: " + this.getSobrenome()
				+ "E-mail: " + this.getEmail() + "Senha: " + this.getSenha()
				+ "Login: " + this.getLogin() + "Matricula: "
				+ this.getMatricula();
	}

	public ArrayList<Resposta> getListaResposta() {
		return listaResposta;
	}

	public void setListaResposta(ArrayList<Resposta> listaResposta) {
		this.listaResposta = listaResposta;
	}

	public ArrayList<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(ArrayList<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
}
