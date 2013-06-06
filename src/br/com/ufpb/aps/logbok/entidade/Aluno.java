package br.com.ufpb.aps.logbok.entidade;

public class Aluno extends Usuario{

	private Disciplina pesquisaDisciplina;
	private Usuario definirNome;
	private Usuario obterNome;
	private LogBook responderLogbook;
	private String matricula; 
	
	
	public Aluno(String nome, String email, String senha, String login,
			String sobrenome, String confirmaSenha) {
		super(nome, email, senha, login, sobrenome, confirmaSenha);
		// TODO Auto-generated constructor stub
	}

	public Disciplina getPesquisaDisciplina() {
		return pesquisaDisciplina;
	}
	
	public void setPesquisaDisciplina(Disciplina pesquisaDisciplina) {
		this.pesquisaDisciplina = pesquisaDisciplina;
	}

	public Usuario getDefinirNome() {
		return definirNome;
	}

	public void setDefinirNome(Usuario definirNome) {
		this.definirNome = definirNome;
	}

	public Usuario getObterNome() {
		return obterNome;
	}

	public void setObterNome(Usuario obterNome) {
		this.obterNome = obterNome;
	}

	public LogBook getResponderLogbook() {
		return responderLogbook;
	}

	public void setResponderLogbook(LogBook responderLogbook) {
		this.responderLogbook = responderLogbook;
	}
	
}
