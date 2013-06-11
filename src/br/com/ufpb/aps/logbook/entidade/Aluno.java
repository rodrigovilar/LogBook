package br.com.ufpb.aps.logbook.entidade;

public class Aluno extends Usuario {

	private String matricula;

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
}
