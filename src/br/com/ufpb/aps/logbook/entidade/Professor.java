package br.com.ufpb.aps.logbook.entidade;

public class Professor extends Usuario {

	private String codigo;
	
	

	public Professor(String nome, String sobrenome, String email, String senha,
			String login, String codigo) {
		super(nome, sobrenome, email, senha, login);
		this.codigo = codigo;
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
}
