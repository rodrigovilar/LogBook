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

	@Test(expected = ProfessorSemDadosException.class)
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
		u.setNome("Simone");
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

	private Turma criarTurma() {
		Turma t = new Turma();
		t.setCodigo("001");
		t.setAnoDaTurma("01-01-00");

		Aluno a = criarAluno();

		List<Aluno> listaAlunos = new ArrayList<Aluno>();
		listaAlunos.add(a);
		t.setAlunos(listaAlunos);

		Professor p = criarProfessor();

		List<Professor> listaProfessores = new ArrayList<Professor>();
		listaProfessores.add(p);
		t.setProfessores(listaProfessores);

		Disciplina d = criarDisciplina();

		List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
		listaDisciplinas.add(d);
		t.setDisciplinas(listaDisciplinas);

		return t;
	}

	@Test
	public void testAdicionarTurma() throws TurmaSemDadosException,
			TurmaJaCadastradaException, TurmaInexistenteException {
		Assert.assertTrue(fachada.listaDisciplinas().isEmpty());
		Turma t = criarTurma();
		fachada.adicionarTurma(t);
		Assert.assertEquals(fachada.listaDisciplinas().size(), 1);
	}

	@Test(expected = TurmaSemDadosException.class)
	public void testAdicionarTurmaSemCodigo() throws TurmaSemDadosException,
			TurmaJaCadastradaException, TurmaInexistenteException {
		Turma t = criarTurma();
		t.setCodigo(null);
		fachada.adicionarTurma(t);
	}

	@Test(expected = TurmaSemDadosException.class)
	public void testAdicionarTurmaSemProfessor() throws TurmaSemDadosException,
			TurmaJaCadastradaException {
		Turma t = criarTurma();
		Professor p = criarProfessor();
		t.setProfessores(p);
	}

	@Test(expected = TurmaJaCadastradaException.class)
	public void testAdicionarTurmaComCodigoJaCadastrado()
			throws TurmaSemDadosException, TurmaJaCadastradaException, TurmaInexistenteException {
		Turma t1 = criarTurma();
		fachada.adicionarTurma(t1);
		Turma t2 = criarTurma();
		fachada.adicionarTurma(t2);
	}

	@Test
	public void testPesquisarTurma() throws TurmaSemDadosException,
			TurmaJaCadastradaException, TurmaInexistenteException {
		Turma t = criarTurma();
		fachada.adicionarTurma(t);
		Assert.assertEquals(t, fachada.pesquisarTurma("001"));
	}

	@Test(expected = TurmaInexistenteException.class)
	public void testPesquisarTurmaInexistente()
			throws TurmaInexistenteException {
		fachada.pesquisarTurma("000");
	}

	@Test
	public void testAtualizarTurma() throws TurmaSemDadosException,
			TurmaJaCadastradaException, TurmaInexistenteException {
		Turma t = criarTurma();
		fachada.adicionarTurma(t);
		t.setAnoDaTurma("01-01-00");
		fachada.editarTurma(t);
		Assert.assertEquals("01-01-00", fachada.pesquisarTurma("001")
				.getAnoDaTurma());
	}

	@Test
	public void testRemoverTurma() throws TurmaInexistenteException,
			TurmaSemDadosException, TurmaJaCadastradaException {
		Assert.assertTrue(fachada.listaTurmas().isEmpty());
		Turma t = criarTurma();
		fachada.adicionarTurma(t);
		Assert.assertFalse(fachada.listaTurmas().isEmpty());
		fachada.deletarTurma("001");
		Assert.assertTrue(fachada.listaTurmas().isEmpty());
	}

	@Test(expected = TurmaInexistenteException.class)
	public void testRemoverTurmaInexistente() throws TurmaInexistenteException {
		fachada.deletarTurma("000");
	}

	private Pratica criarPratica() {
		Pratica p = new Pratica();
		p.setNumeroPratica("01");

		Disciplina d = criarDisciplina();
		p.setDisciplina(d);

		Pergunta perg = new Pergunta();
		perg.setCodPergunta("01");
		perg.setPergunta("Quem descobriu o Brasil?");

		List<Pergunta> listaPerguntas = new ArrayList<Pergunta>();
		listaPerguntas.add(perg);
		p.setListaPerguntas(listaPerguntas);

		return p;
	}

	@Test
	public void testAdicionarPratica() throws PraticaSemDadosException,
			PraticaJaCadastradaException, PraticaInexistenteException {
		Assert.assertTrue(fachada.listaPraticas().isEmpty());
		Pratica p = criarPratica();
		fachada.adicionarPratica(p);
		Assert.assertEquals(fachada.listaPraticas().size(), 1);
	}

	@Test(expected = PraticaSemDadosException.class)
	public void testAdicionarPraticaSemNumero()
			throws PraticaSemDadosException, PraticaJaCadastradaException,
			PraticaInexistenteException {
		Pratica p = criarPratica();
		p.setNumeroPratica(null);
		fachada.adicionarPratica(p);
	}

	@Test
	public void testAdicionarPraticaSemDisciplina()
			throws TurmaSemDadosException, TurmaJaCadastradaException {
		Pratica p = criarPratica();
		Disciplina d = criarDisciplina();
		p.setDisciplina(d);
	}

	@Test
	public void testPesquisarPratica() throws PraticaSemDadosException,
			PraticaJaCadastradaException, PraticaInexistenteException {
		Pratica p = criarPratica();
		fachada.adicionarPratica(p);
		Assert.assertEquals(p, fachada.pesquisarPratica("01"));
	}

	@Test(expected = PraticaInexistenteException.class)
	public void testPesquisarPraticaInexistente()
			throws PraticaInexistenteException {
		fachada.pesquisarPratica("00");
	}

	@Test
	public void tesRemoverPratica() throws PraticaSemDadosException,
			PraticaJaCadastradaException, PraticaInexistenteException {
		Assert.assertTrue(fachada.listaPraticas().isEmpty());
		Pratica p = criarPratica();
		fachada.adicionarPratica(p);
		Assert.assertFalse(fachada.listaPraticas().isEmpty());
		fachada.deletarPratica("01");
		Assert.assertTrue(fachada.listaPraticas().isEmpty());
	}

	@Test(expected = PraticaInexistenteException.class)
	public void testRemoverPraticaInexistente()
			throws PraticaInexistenteException {
		fachada.deletarPratica("00");
	}

	private Pergunta criarPergunta() {
		Pergunta p = new Pergunta();
		p.setCodPergunta("01");
		p.setPergunta("O que é um objeto?");

		return p;
	}

	@Test
	public void testAdicionarPergunta() throws PerguntaSemDadosException,
			PerguntaJaCadastradaException, PerguntaInexistenteException {
		Assert.assertTrue(fachada.listPerguntas().isEmpty());
		Pergunta p = criarPergunta();
		fachada.adicionarPergunta(p);
		Assert.assertEquals(fachada.listPerguntas().size(), 1);
	}

	@Test(expected = PerguntaSemDadosException.class)
	public void testAdcionarPraticaSemCodigo()
			throws PerguntaSemDadosException, PerguntaJaCadastradaException,
			PerguntaInexistenteException {
		Pergunta p = criarPergunta();
		p.setCodPergunta(null);
		fachada.adicionarPergunta(p);
	}

	@Test(expected = PerguntaJaCadastradaException.class)
	public void testPerguntaComCodigoJaCadastrado()
			throws PerguntaJaCadastradaException, PerguntaSemDadosException,
			PerguntaInexistenteException {
		Pergunta p1 = criarPergunta();
		fachada.adicionarPergunta(p1);
		Pergunta p2 = criarPergunta();
		fachada.adicionarPergunta(p2);
	}

	@Test(expected = PerguntaSemDadosException.class)
	public void testPerguntaSemPergunta() throws PerguntaSemDadosException,
			PerguntaJaCadastradaException, PerguntaInexistenteException {
		Pergunta p = criarPergunta();
		p.setPergunta(null);
		fachada.adicionarPergunta(p);
	}

	@Test
	public void testPesquisarPergunta() throws PerguntaSemDadosException,
			PerguntaJaCadastradaException, PerguntaInexistenteException {
		Pergunta p = criarPergunta();
		fachada.adicionarPergunta(p);
		Assert.assertEquals(p, fachada.pesquisarPergunta("01"));
	}

	@Test(expected = PerguntaInexistenteException.class)
	public void testPesquisarInexistente() throws PerguntaInexistenteException {
		fachada.pesquisarPergunta("00");
	}

	@Test
	public void testRemoverPergunta() throws PerguntaSemDadosException,
			PerguntaInexistenteException, PerguntaJaCadastradaException,
			PerguntaInexistenteException {		
		Assert.assertTrue(fachada.listPerguntas().isEmpty());
		Pergunta p = criarPergunta();
		fachada.adicionarPergunta(p);
		Assert.assertFalse(fachada.listPerguntas().isEmpty());
		fachada.deletarPergunta("01");
		Assert.assertTrue(fachada.listPerguntas().isEmpty());
	}

	@Test(expected = PerguntaInexistenteException.class)
	public void testRemoverPerguntaInexistente()
			throws PraticaInexistenteException, PerguntaInexistenteException {
		fachada.deletarPergunta("00");
	}

	@Test
	public void testAtualizarPergunta() throws PerguntaSemDadosException,
			PerguntaJaCadastradaException, PerguntaInexistenteException {
		Pergunta p = criarPergunta();
		fachada.adicionarPergunta(p);
		p.setCodPergunta("02");
		fachada.editarPergunta(p);
		Assert.assertEquals("02", fachada.pesquisarPergunta("02")
				.getCodPergunta());
	}

	private Resposta criarResposta() {
		Resposta r = new Resposta();
		r.setCodResposta("01");
		r.setConteudo("objeto é uma classe!");

		return r;
	}

	@Test
	public void testAdicionarResposta() throws RespostaSemDadosException,
			RespostaJaCadastradaException, RespostaInexistenteException {
		Assert.assertTrue(fachada.listaRespostas().isEmpty());
		Resposta r = criarResposta();
		fachada.adicionarRespota(r);
		Assert.assertEquals(fachada.listaRespostas().size(), 1);
	}

	@Test(expected = RespostaSemDadosException.class)
	public void testAdcionarRespostaSemCodigo()
			throws RespostaSemDadosException, RespostaJaCadastradaException, RespostaInexistenteException {
		Resposta r = criarResposta();
		r.setCodResposta(null);
		fachada.adicionarRespota(r);
	}

	@Test(expected = RespostaJaCadastradaException.class)
	public void testRespostaComCodigoJaCadastrado()
			throws RespostaJaCadastradaException, RespostaSemDadosException, RespostaInexistenteException {
		Resposta r1 = criarResposta();
		fachada.adicionarRespota(r1);
		Resposta r2 = criarResposta();
		fachada.adicionarRespota(r2);
	}

	@Test(expected = RespostaSemDadosException.class)
	public void testRespostaSemPergunta() throws RespostaSemDadosException, RespostaJaCadastradaException, RespostaInexistenteException {
		Resposta r = criarResposta();
		r.setCodResposta(null);
		fachada.adicionarRespota(r);
	}

	@Test
	public void testPesquisarResposta() throws RespostaSemDadosException,
			RespostaJaCadastradaException, RespostaInexistenteException {
		Resposta r = criarResposta();
		fachada.adicionarRespota(r);
		Assert.assertEquals(r, fachada.pesquisarResposta("01"));
	}

	@Test(expected = RespostaInexistenteException.class)
	public void testRespostaInexistente() throws RespostaInexistenteException {
		fachada.pesquisarResposta("00");
	}

	@Test
	public void testRemoverResposta() throws RespostaSemDadosException,
			RespostaInexistenteException, RespostaJaCadastradaException {
		Assert.assertTrue(fachada.listaRespostas().isEmpty());
		Resposta r = criarResposta();
		fachada.adicionarRespota(r);
		Assert.assertFalse(fachada.listaRespostas().isEmpty());
		fachada.deletarRespota("01");
		Assert.assertTrue(fachada.listaRespostas().isEmpty());
	}

	@Test(expected = RespostaInexistenteException.class)
	public void testRemoverRespostaInexistente()
			throws RespostaInexistenteException {
		fachada.deletarRespota("00");
	}

	@Test
	public void tesAtualizarResposta() throws RespostaSemDadosException, RespostaJaCadastradaException, RespostaInexistenteException {
		Resposta r = criarResposta();
		fachada.adicionarRespota(r);
		r.setCodResposta("02");
		fachada.editarResposta(r);
		Assert.assertEquals("02", fachada.pesquisarResposta("02")
				.getCodResposta());
	}

	private LogBook criarLogBook() {
		LogBook lb = new LogBook();
		lb.setCodLogBook("01");
		lb.setAssunto("Programação com Java");
		lb.setHora("04:20");
		lb.setData("07-10-2013");

		Professor p = new Professor();
		lb.setProfessor(p);

		Turma t = new Turma();
		lb.setTurma(t);

		Disciplina d = new Disciplina();
		lb.setDisciplina(d);

		Pergunta perg = new Pergunta();
		perg.setCodPergunta("01");
		perg.setPergunta("O que é uma variavel?");

		List<Pergunta> listaPergunta = new ArrayList<Pergunta>();
		lb.setListaPergunta(listaPergunta);

		Pratica p1 = new Pratica();
		p1.setNumeroPratica("001");

		List<Pratica> listaPratica = new ArrayList<Pratica>();
		lb.setListaPratica(listaPratica);

		Resposta resp = new Resposta();
		resp.setCodResposta("01");
		resp.setConteudo(" é uma posição, frequentemente localizada na memória");

		List<Resposta> listaResposta = new ArrayList<Resposta>();
		lb.setListaResposta(listaResposta);

		return lb;
	}

	@Test
	public void testAdicionarLogBook() throws LogBookSemDadosException,
			LogBookJaCadastradoException, LogBookInexistenteException,
			AlunoSemDadosException, AlunoJaCadastradoException,
			AlunoInexistenteException {
		Assert.assertTrue(fachada.listaLogBooks().isEmpty());
		LogBook lb = criarLogBook();
		fachada.adicionarLogBook(lb);
		Assert.assertEquals(fachada.listaLogBooks().size(), 1);
	}

	@Test(expected = LogBookSemDadosException.class)
	public void testAdicionarLogBookSemCodigo()
			throws LogBookSemDadosException, AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException, LogBookJaCadastradoException {
		LogBook lb = criarLogBook();
		lb.setCodLogBook(null);
		fachada.adicionarLogBook(lb);
	}

	@Test(expected = LogBookSemDadosException.class)
	public void testAdicionarLogBookSemProfessor()
			throws LogBookSemDadosException {
		LogBook lb = criarLogBook();
		Professor p = criarProfessor();
		lb.setProfessor(p);
	}

	@Test(expected = LogBookSemDadosException.class)
	public void testAdicionarLogBookSemDisciplina()
			throws LogBookSemDadosException, LogBookJaCadastradoException {
		LogBook lb = criarLogBook();
		Disciplina d = criarDisciplina();
		lb.setDisciplina(d);
	}

	@Test(expected = LogBookSemDadosException.class)
	public void testAdicionarLogBookSemTurma() throws LogBookSemDadosException,
			LogBookJaCadastradoException {
		LogBook lb = criarLogBook();
		Turma t = criarTurma();
		lb.setTurma(t);
	}

	@Test
	public void testPesquisarLogBook() throws LogBookSemDadosException,
			LogBookJaCadastradoException, LogBookInexistenteException,
			AlunoSemDadosException, AlunoJaCadastradoException,
			AlunoInexistenteException {
		LogBook lb = criarLogBook();
		fachada.adicionarLogBook(lb);
		Assert.assertEquals(lb, fachada.pesquisaLogBook("01"));
	}

	@Test(expected = LogBookInexistenteException.class)
	public void testPesquisarLogBookInexistente()
			throws LogBookInexistenteException, AlunoInexistenteException {
		fachada.pesquisaLogBook("00");
	}

	@Test
	public void tesRemoverLogBook() throws LogBookSemDadosException,
			LogBookJaCadastradoException, LogBookInexistenteException,
			AlunoSemDadosException, AlunoJaCadastradoException,
			AlunoInexistenteException {
		Assert.assertTrue(fachada.listaLogBooks().isEmpty());
		LogBook lb = criarLogBook();
		fachada.adicionarLogBook(lb);
		Assert.assertFalse(fachada.listaLogBooks().isEmpty());
		fachada.deletarLogBook("01");
		Assert.assertTrue(fachada.listaLogBooks().isEmpty());
	}

	@Test(expected = LogBookInexistenteException.class)
	public void testRemoverLogBookInexistente()
			throws LogBookInexistenteException, AlunoInexistenteException {
		fachada.deletarLogBook("00");
	}
}