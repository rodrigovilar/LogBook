package br.com.ufpb.aps.logbook.testes;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

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
import br.com.ufpb.aps.logbook.fachada.LogbookFachada;

public class LogBookTeste {

	LogbookFachada fachada;

	@Before
	public void criarFacadeLogbook() {
		fachada = new LogbookFachada();
	}

	private Aluno criarAluno() {
		Aluno a1 = new Aluno();
		a1.setNome("Luiz Fernando");
		a1.setSobrenome("Paiva");
		a1.setMatricula("80911008");
		a1.setEmail("fernando.paiva@dce.ufpb.br");
		a1.setLogin("fernandopaiva");
		a1.setSenha("12345");
		return a1;
	}

	@Test
	public void testAdicionarAluno() throws AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException {
		Assert.assertTrue(fachada.listaTodosAlunos().isEmpty());
		Aluno a1 = criarAluno();
		fachada.adicionarAluno(a1);
		Assert.assertEquals(fachada.listaTodosAlunos().size(), 1);
	}

	@Test(expected = AlunoSemDadosException.class)
	public void testAdicionarAlunoSemMatricula() throws AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException {
		Aluno a1 = criarAluno();
		a1.setMatricula(null);
		fachada.adicionarAluno(a1);
	}

	@Test(expected = AlunoSemDadosException.class)
	public void testAdicionarAlunoSemEmail() throws AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException {
		Aluno a1 = criarAluno();
		a1.setEmail(null);
		fachada.adicionarAluno(a1);
	}

	@Test(expected = AlunoJaCadastradoException.class)
	public void testAdicionarAlunoJaCadastrado() throws AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException {
		Aluno a1 = criarAluno();
		fachada.adicionarAluno(a1);
		Aluno a2 = criarAluno();
		fachada.adicionarAluno(a2);
	}

	@Test
	public void testPesquisarAluno() throws AlunoSemDadosException,
			AlunoInexistenteException, AlunoJaCadastradoException {
		Aluno a1 = criarAluno();
		fachada.adicionarAluno(a1);
		Assert.assertEquals(a1, fachada.pesquisarAluno("80911008"));
	}

	@Test(expected = AlunoInexistenteException.class)
	public void testPesquisarAlunoInexistente()
			throws AlunoInexistenteException {
		fachada.pesquisarAluno("12233445");
	}

	@Test
	public void testAtualizarAluno() throws AlunoSemDadosException,
			AlunoInexistenteException, AlunoJaCadastradoException {
		Aluno a1 = criarAluno();
		fachada.adicionarAluno(a1);
		a1.setNome("José");
		fachada.editarDadosAluno(a1);
		Assert.assertEquals("José", fachada.pesquisarAluno("80911008")
				.getNome());
	}

	@Test
	public void testRemoverAluno() throws AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException {
		Assert.assertTrue(fachada.listaTodosAlunos().isEmpty());
		Aluno a1 = criarAluno();
		fachada.adicionarAluno(a1);
		Assert.assertFalse(fachada.listaTodosAlunos().isEmpty());
		fachada.deletarAluno("80911008");
		Assert.assertTrue(fachada.listaTodosAlunos().isEmpty());
	}

	@Test(expected = AlunoInexistenteException.class)
	public void testRemoverAlunoInexistente() throws AlunoSemDadosException,
			AlunoInexistenteException {
		fachada.deletarAluno("12233445");
	}

	private Disciplina criarDisciplina() {
		Disciplina d1 = new Disciplina();
		d1.setNomeDisciplina("Analise e Projeto de Sistemas");
		d1.setCodigoDisciplina("001");
		Professor p = criarProfessor();
		d1.setProfessor(p);
		return d1;
	}

	@Test
	public void testAdicionarDisciplina() throws DisciplinaSemDadosException,
			DisciplinaJaCadastradaException {
		Assert.assertTrue(fachada.listaDisciplinas().isEmpty());
		Disciplina d = criarDisciplina();
		fachada.adicionarDisciplina(d);
		Assert.assertEquals(fachada.listaDisciplinas().size(), 1);
	}

	@Test(expected = DisciplinaSemDadosException.class)
	public void testAdicionarDisciplinaSemCodigo()
			throws DisciplinaSemDadosException, DisciplinaJaCadastradaException {
		Disciplina d = criarDisciplina();
		d.setCodigoDisciplina(null);
		fachada.adicionarDisciplina(d);
	}

	@Test(expected = DisciplinaSemDadosException.class)
	public void testAdicionarDisciplinaSemProfessor()
			throws DisciplinaSemDadosException, DisciplinaJaCadastradaException {
		Disciplina d = criarDisciplina();
		d.setProfessor(null);
		fachada.adicionarDisciplina(d);
	}

	@Test(expected = DisciplinaJaCadastradaException.class)
	public void testAdicionarDisciplinaComCodigoJaCadastrado()
			throws DisciplinaSemDadosException, DisciplinaJaCadastradaException {
		Disciplina d1 = criarDisciplina();
		fachada.adicionarDisciplina(d1);
		Disciplina d2 = criarDisciplina();
		fachada.adicionarDisciplina(d2);
	}

	@Test
	public void testPesquisarDisciplina() throws DisciplinaSemDadosException,
			DisciplinaJaCadastradaException, DisciplinaInexistenteException {
		Disciplina d = criarDisciplina();
		fachada.adicionarDisciplina(d);
		Assert.assertEquals(d, fachada.pesquisarDisciplina("001"));
	}

	@Test(expected = DisciplinaInexistenteException.class)
	public void testPesquisarDisciplinaInexistente()
			throws DisciplinaInexistenteException {
		fachada.pesquisarDisciplina("000");
	}

	@Test
	public void testAtualizarDisciplina() throws DisciplinaSemDadosException,
			DisciplinaJaCadastradaException, DisciplinaInexistenteException {
		Disciplina d = criarDisciplina();
		fachada.adicionarDisciplina(d);
		d.setNomeDisciplina("Portugues");
		fachada.editarDisciplina(d);
		Assert.assertEquals("Portugues", fachada.pesquisarDisciplina("001")
				.getNomeDisciplina());
	}

	@Test
	public void testRemoverDisciplina() throws DisciplinaSemDadosException,
			DisciplinaJaCadastradaException, DisciplinaInexistenteException {
		Assert.assertTrue(fachada.listaDisciplinas().isEmpty());
		Disciplina d = criarDisciplina();
		fachada.adicionarDisciplina(d);
		Assert.assertFalse(fachada.listaDisciplinas().isEmpty());
		fachada.deletarDisciplina("001");
		Assert.assertTrue(fachada.listaDisciplinas().isEmpty());
	}

	@Test(expected = DisciplinaInexistenteException.class)
	public void testRemoverDisciplinaInexistente()
			throws DisciplinaInexistenteException {
		fachada.deletarDisciplina("000");
	}

	private Professor criarProfessor() {
		Professor p1 = new Professor();
		p1.setNome("Rodrigo");
		p1.setSobrenome("Vilar");
		p1.setEmail("rodrigov@dce.ufpb.br");
		p1.setLogin("rodrigov");
		p1.setCodigo("001");
		p1.setSenha("1234");

		return p1;
	}

	@Test
	public void testAdicionarProfessor() throws ProfessorSemDadosException,
			ProfessorJaCadastradoException, ProfessorInexistenteException {
		Assert.assertTrue(fachada.listaTodosProfessores().isEmpty());
		Professor p = criarProfessor();
		fachada.adicionarProfessor(p);
		Assert.assertEquals(1, fachada.listaTodosProfessores().size());
	}

	@Test(expected = ProfessorSemDadosException.class)
	public void testAdicionarProfessorSemCodigo()
			throws ProfessorSemDadosException, ProfessorJaCadastradoException,
			ProfessorInexistenteException {
		Professor p = criarProfessor();
		p.setCodigo(null);
		fachada.adicionarProfessor(p);
	}

	@Test
	// (expected = ProfessorSemDadosException.class)
	public void testAdicionarProfessorSemDisciplina()
			throws ProfessorSemDadosException, ProfessorJaCadastradoException,
			ProfessorInexistenteException {
		Professor p = criarProfessor();
		p.setDisciplina(null);
		fachada.adicionarProfessor(p);
	}

	@Test(expected = ProfessorSemDadosException.class)
	public void testAdicionarProfessorSemEmail()
			throws ProfessorSemDadosException, ProfessorJaCadastradoException,
			ProfessorInexistenteException {
		Professor p = criarProfessor();
		p.setEmail(null);
		fachada.adicionarProfessor(p);
	}

	@Test(expected = ProfessorJaCadastradoException.class)
	public void testAdicionarProfessorComCodigoJaCadastrado()
			throws ProfessorSemDadosException, ProfessorJaCadastradoException,
			ProfessorInexistenteException {
		Professor p1 = criarProfessor();
		fachada.adicionarProfessor(p1);
		Professor p2 = criarProfessor();
		fachada.adicionarProfessor(p2);
	}

	@Test
	public void testPesquisarProfessor() throws ProfessorSemDadosException,
			ProfessorJaCadastradoException, ProfessorInexistenteException {
		Professor p = criarProfessor();
		fachada.adicionarProfessor(p);
		Assert.assertEquals(p, fachada.pesquisarProfessor("001"));
	}

	@Test(expected = ProfessorInexistenteException.class)
	public void testPesquisarProfessorInexistente()
			throws ProfessorInexistenteException {
		fachada.pesquisarProfessor("123456789");
	}

	@Test
	public void testAtualizarProfessor() throws ProfessorSemDadosException,
			ProfessorJaCadastradoException, ProfessorInexistenteException {
		Professor p1 = criarProfessor();
		fachada.adicionarProfessor(p1);
		p1.setNome("Rodrigo");
		fachada.editarProfessor(p1);
		Assert.assertEquals("Rodrigo", fachada.pesquisarProfessor("001")
				.getNome());
	}

	@Test
	public void testRemoverProfessor() throws ProfessorSemDadosException,
			ProfessorJaCadastradoException, ProfessorInexistenteException {
		Assert.assertTrue(fachada.listaTodosProfessores().isEmpty());
		Professor p1 = criarProfessor();
		fachada.adicionarProfessor(p1);
		Assert.assertFalse(fachada.listaTodosProfessores().isEmpty());
		fachada.deletarProfessor("001");
		Assert.assertTrue(fachada.listaTodosProfessores().isEmpty());
	}

	private Usuario criarUsuario() {
		Usuario u = new Usuario();
		u.setCodigo("001");
		u.setNome("Simone");
		u.setEmail("email");
		u.setLogin("login");
		u.setNome("nome");
		u.setSenha("1234");
		u.setSobrenome("sobrenome");

		return u;
	}

	@Test
	public void testAdicionarUsuario() throws UsuarioSemDadosException,
			UsuarioJaCadastradoException {
		Assert.assertTrue(fachada.listaTodosUsuarios().isEmpty());
		Usuario u = criarUsuario();
		fachada.adicionarUsuario(u);
		Assert.assertEquals(fachada.listaTodosUsuarios().size(), 1);
	}

	@Test(expected = UsuarioSemDadosException.class)
	public void testAdicionarUsuarioSemCodigo()
			throws UsuarioSemDadosException, UsuarioJaCadastradoException {
		Usuario u = criarUsuario();
		u.setCodigo(null);
		fachada.adicionarUsuario(u);
	}

	@Test(expected = UsuarioSemDadosException.class)
	public void testAdicionarUsuarioSemEmail() throws UsuarioSemDadosException,
			UsuarioJaCadastradoException {
		Usuario u = criarUsuario();
		u.setEmail(null);
		fachada.adicionarUsuario(u);
	}

	@Test(expected = UsuarioJaCadastradoException.class)
	public void testAdicionarUsuarioJaCadastrado()
			throws UsuarioSemDadosException, UsuarioJaCadastradoException {
		Usuario u1 = criarUsuario();
		fachada.adicionarUsuario(u1);
		Usuario u2 = criarUsuario();
		fachada.adicionarUsuario(u2);
	}

	@Test
	public void testPesquisarUsuario() throws UsuarioSemDadosException,
			UsuarioInexistenteException, UsuarioJaCadastradoException {
		Usuario u = criarUsuario();
		fachada.adicionarUsuario(u);
		Assert.assertEquals(u, fachada.pesquisarUsuario("001"));
	}

	@Test(expected = UsuarioInexistenteException.class)
	public void testPesquisarUsuarioInexistente()
			throws UsuarioInexistenteException {
		fachada.pesquisarUsuario("1234567");
	}

	@Test
	public void testAtualizarUsuario() throws UsuarioSemDadosException,
			UsuarioInexistenteException, UsuarioJaCadastradoException {
		Usuario u = criarUsuario();
		fachada.adicionarUsuario(u);
		u.setNome("José");
		fachada.editarDadosUsuario(u);
		Assert.assertEquals("José", fachada.pesquisarUsuario("001").getNome());
	}

	@Test
	public void testRemoverUsuario() throws UsuarioSemDadosException,
			UsuarioJaCadastradoException, UsuarioInexistenteException {
		Assert.assertTrue(fachada.listaTodosAlunos().isEmpty());
		Usuario u = criarUsuario();
		fachada.adicionarUsuario(u);
		Assert.assertFalse(fachada.listaTodosUsuarios().isEmpty());
		fachada.deletarUsuario("001");
		Assert.assertTrue(fachada.listaTodosUsuarios().isEmpty());
	}

	@Test(expected = UsuarioInexistenteException.class)
	public void testRemoverUsuarioInexistente()
			throws UsuarioSemDadosException, UsuarioInexistenteException {
		fachada.deletarUsuario("001");
	}
}