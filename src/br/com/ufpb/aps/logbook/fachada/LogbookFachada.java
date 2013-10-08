package br.com.ufpb.aps.logbook.fachada;

import java.util.List;

import br.com.ufpb.aps.logbook.controlador.GerenciadorAluno;
import br.com.ufpb.aps.logbook.controlador.GerenciadorDisciplina;
import br.com.ufpb.aps.logbook.controlador.GerenciadorLogBook;
import br.com.ufpb.aps.logbook.controlador.GerenciadorPergunta;
import br.com.ufpb.aps.logbook.controlador.GerenciadorPratica;
import br.com.ufpb.aps.logbook.controlador.GerenciadorProfessor;
import br.com.ufpb.aps.logbook.controlador.GerenciadorResposta;
import br.com.ufpb.aps.logbook.controlador.GerenciadorTurma;
import br.com.ufpb.aps.logbook.controlador.GerenciadorUsuario;
import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.LogBook;
import br.com.ufpb.aps.logbook.entidade.Pergunta;
import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.entidade.Resposta;
import br.com.ufpb.aps.logbook.entidade.Turma;
import br.com.ufpb.aps.logbook.entidade.Usuario;
import br.com.ufpb.aps.logbook.excecao.AlunoInexistenteException;
import br.com.ufpb.aps.logbook.excecao.AlunoJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.AlunoSemDadosException;
import br.com.ufpb.aps.logbook.excecao.DisciplinaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.DisciplinaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.DisciplinaSemDadosException;
import br.com.ufpb.aps.logbook.excecao.LogBookInexistenteException;
import br.com.ufpb.aps.logbook.excecao.LogBookJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.LogBookSemDadosException;
import br.com.ufpb.aps.logbook.excecao.PerguntaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.PerguntaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.PerguntaSemDadosException;
import br.com.ufpb.aps.logbook.excecao.PraticaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.PraticaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.PraticaSemDadosException;
import br.com.ufpb.aps.logbook.excecao.ProfessorInexistenteException;
import br.com.ufpb.aps.logbook.excecao.ProfessorJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.ProfessorSemDadosException;
import br.com.ufpb.aps.logbook.excecao.RespostaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.RespostaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.RespostaSemDadosException;
import br.com.ufpb.aps.logbook.excecao.TurmaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.TurmaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.TurmaSemDadosException;
import br.com.ufpb.aps.logbook.excecao.UsuarioInexistenteException;
import br.com.ufpb.aps.logbook.excecao.UsuarioJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.UsuarioSemDadosException;

public class LogbookFachada {
	GerenciadorAluno galuno = new GerenciadorAluno();
	GerenciadorProfessor gprofessor = new GerenciadorProfessor();
	GerenciadorDisciplina gdisciplina = new GerenciadorDisciplina();
	GerenciadorLogBook glogbook = new GerenciadorLogBook();
	GerenciadorPratica gpratica = new GerenciadorPratica();
	GerenciadorTurma gturma = new GerenciadorTurma();
	GerenciadorUsuario gusuario = new GerenciadorUsuario();
	GerenciadorResposta gresposta = new GerenciadorResposta();
	GerenciadorPergunta gpergunta = new GerenciadorPergunta();
	// Datos do Aluno
	public void adicionarAluno(Aluno aluno) throws AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException {
		galuno.adicionarAluno(aluno);
	}
	public Aluno pesquisarAluno(String matricula)
			throws AlunoInexistenteException {
		return galuno.pesquisarAluno(matricula);
	}
	public Aluno editarDadosAluno(Aluno aluno) throws AlunoInexistenteException {
		return galuno.editarDadosAluno(aluno);
	}
	public void deletarAluno(String matricula) throws AlunoInexistenteException {
		galuno.deletarAluno(matricula);
	}
	public List<Aluno> listaTodosAlunos() {
		return galuno.getListaTodosAlunos();
	}
	// Dados da Disciplina
	public void adicionarDisciplina(Disciplina disciplina)
			throws DisciplinaSemDadosException, DisciplinaJaCadastradaException {
		gdisciplina.adicionarDisciplina(disciplina);
	}
	public Disciplina pesquisarDisciplina(String codigoDisciplina)
			throws DisciplinaInexistenteException {
		return gdisciplina.pesquisarDisciplina(codigoDisciplina);
	}
	public Disciplina editarDisciplina(Disciplina disciplina)
			throws DisciplinaInexistenteException {
		return gdisciplina.editarDisciplina(disciplina);
	}
	public void deletarDisciplina(String codigoDisciplina)
			throws DisciplinaInexistenteException {
		gdisciplina.deletarDisciplina(codigoDisciplina);
	}
	public List<Disciplina> listaDisciplinas() {
		return gdisciplina.getListaDisciplinas();
	}
	// Dados do LogBook
	public void adicionarLogBook(LogBook logbook)
			throws AlunoSemDadosException, AlunoJaCadastradoException,
			AlunoInexistenteException, LogBookSemDadosException,
			LogBookJaCadastradoException {
		glogbook.adicionarLogBook(logbook);
	}
	public LogBook editarLogBook(LogBook logbook)
			throws AlunoInexistenteException, LogBookInexistenteException {
		return glogbook.editarLogBook(logbook);
	}
	public LogBook pesquisaLogBook(String codLogBook)
			throws AlunoInexistenteException, LogBookInexistenteException {
		return glogbook.pesquisarLogBook(codLogBook);
	}
	public void deletarLogBook(String codLogBook)
			throws AlunoInexistenteException, LogBookInexistenteException {
		glogbook.deletarLogBook(codLogBook);
	}
	public List<LogBook> listaLogBooks() {
		return glogbook.listaLogBooks();
	}
	// Dados da Pergunta
	public void adicionarPergunta(Pergunta novaPergunta)
			throws PerguntaSemDadosException, PerguntaJaCadastradaException,
			PerguntaInexistenteException {
		gpergunta.adicionarPergunta(novaPergunta);
	}
	public Pergunta editarPergunta(Pergunta pergunta)
			throws PerguntaInexistenteException {
		return gpergunta.editarPergunta(pergunta);
	}
	public Pergunta pesquisarPergunta(String pergunta)
			throws PerguntaInexistenteException {
		return gpergunta.pesquisarPergunta(pergunta);
	}
	public void deletarPergunta(String codPergunta)
			throws PerguntaInexistenteException {
		gpergunta.deletarPergunta(codPergunta);
	}
	public List<Pergunta> listPerguntas() {
		return gpergunta.getListPerguntas();
	}
	// Dados da Prática
	public void adicionarPratica(Pratica pratica)
			throws PraticaSemDadosException, PraticaJaCadastradaException,
			PraticaInexistenteException {
		gpratica.adicionarPraticaProfessor(pratica);
	}
	public Pratica editarPratica(Pratica pratica)
			throws PraticaInexistenteException {
		return gpratica.editarPratica(pratica);
	}
	public void deletarPratica(String numeroPratica)
			throws PraticaInexistenteException {
		gpratica.deletarPratica(numeroPratica);
	}
	public Pratica pesquisarPratica(String numeroPratica)
			throws PraticaInexistenteException {
		return gpratica.pesquisarPratica(numeroPratica);
	}
	public List<Pratica> listaPraticas() {
		return gpratica.getPraticas();
	}
	// Dados do Professor
	public void adicionarProfessor(Professor professor)
			throws ProfessorSemDadosException, ProfessorJaCadastradoException,
			ProfessorInexistenteException {
		gprofessor.adicionarProfessor(professor);
	}
	public Professor pesquisarProfessor(String codigo)
			throws ProfessorInexistenteException {
		return gprofessor.pesquisarProfessor(codigo);
	}
	public Professor editarProfessor(Professor professor)
			throws ProfessorInexistenteException {
		return gprofessor.editarDadosProfessor(professor);
	}
	public void deletarProfessor(String codigo)
			throws ProfessorInexistenteException {
		gprofessor.deletarProfessor(codigo);
	}
	public List<Professor> listaTodosProfessores() {
		return gprofessor.getlistaTodosProfessores();
	}
	// Dados da Resposta
	public void adicionarRespota(Resposta novaResposta)
			throws RespostaSemDadosException, RespostaJaCadastradaException,
			RespostaInexistenteException {
		gresposta.adicionarRespota(novaResposta);
	}
	public Resposta editarResposta(Resposta resposta)
			throws RespostaInexistenteException {
		return gresposta.editarResposta(resposta);
	}
	public Resposta pesquisarResposta(String codResposta)
			throws RespostaInexistenteException {
		return gresposta.pesquisarResposta(codResposta);
	}
	public void deletarRespota(String codResposta)
			throws RespostaInexistenteException {
		gresposta.deletarRespota(codResposta);
	}
	public List<Resposta> listaRespostas() {
		return gresposta.getListaRespostas();
	}
	// Dados da Turma
	public void adicionarTurma(Turma novaTurma) throws TurmaSemDadosException,
			TurmaJaCadastradaException, TurmaInexistenteException {
		gturma.adicionarTurma(novaTurma);
	}
	public Turma editarTurma(Turma turma) throws TurmaInexistenteException {
		return gturma.editarTurma(turma);
	}
	public void deletarTurma(String codigoTurma)
			throws TurmaInexistenteException {
		gturma.deletarTurma(codigoTurma);
	}
	public Turma pesquisarTurma(String codigoTurma)
			throws TurmaInexistenteException {
		return gturma.pesquisarTurma(codigoTurma);
	}
	public List<Turma> listaTurmas() {
		return gturma.getListaTurmas();
	}
	// Dados do Usuário
	public void adicionarUsuario(Usuario novoUsuario)
			throws UsuarioSemDadosException, UsuarioJaCadastradoException {
		gusuario.adicionarUsuario(novoUsuario);
	}
	public Usuario editarDadosUsuario(Usuario usuario)
			throws UsuarioInexistenteException {
		return gusuario.editarDadosUsuario(usuario);
	}
	public Usuario pesquisarUsuario(String codigo)
			throws UsuarioInexistenteException {
		return gusuario.pesquisarUsuario(codigo);
	}
	public void deletarUsuario(String codigo)
			throws UsuarioInexistenteException {
		gusuario.deletarUsuario(codigo);
	}
	public List<Usuario> listaTodosUsuarios() {
		return gusuario.getListaTodosUsuarios();
	}
}
