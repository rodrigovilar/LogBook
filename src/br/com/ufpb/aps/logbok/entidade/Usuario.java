package br.com.ufpb.aps.logbok.entidade;

public class Usuario {

	protected String nome;
	protected String sobrenome;
	protected String email;
	protected String senha;
	protected String confirmaSenha;
	protected String login;
	
	public Usuario(String nome, String email, String senha, String login,String sobrenome,String confirmaSenha){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.login = login;
		this.confirmaSenha = confirmaSenha;
		this.sobrenome = sobrenome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}
