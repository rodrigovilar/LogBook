package br.com.ufpb.aps.logbook.entidade;

public class Usuario {
	// O email é a chave primaria
	private String email;
	private String nome;
	private String sobrenome;
	private String senha;
	private String login;
	private String codigo;
	public Usuario(String nome, String sobrenome, String email, String senha,
			String login, String codigo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.login = login;
		this.setCodigo(codigo);
	}
	public Usuario() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
