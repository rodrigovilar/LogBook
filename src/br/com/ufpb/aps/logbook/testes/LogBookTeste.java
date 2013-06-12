package br.com.ufpb.aps.logbook.testes;

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
import br.com.ufpb.aps.logbook.fachada.LogbookFachada;

public class LogBookTeste {

	LogbookFachada fachada;

	@Before
	public void criarFacadeLogbook() {
		fachada = new LogbookFachada();
	}

	@Test
	public void testCrudAluno() {

		Aluno a1 = new Aluno();
		a1.setNome("Luiz Fernando");
		a1.setSobrenome("Paiva");
		a1.setMatricula("80911008");
		a1.setEmail("fernando.paiva@dce.ufpb.br");
		a1.setLogin("fernandopaiva");
		a1.setSenha("12345");
		Assert.assertTrue(fachada.listaTodosAlunos().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarAluno(a1);
		Assert.assertFalse(fachada.listaTodosAlunos().isEmpty());
		Assert.assertEquals(a1, fachada.pesquisarAluno("80911008"));
		// UPDATE ENTIDADE
		a1.setNome("josé");
		fachada.EditarDadosAluno(a1);
		Assert.assertFalse(fachada.listaTodosAlunos().isEmpty());
		Assert.assertEquals("josé", fachada.pesquisarAluno("80911008").getNome());
		// GET ENTIDADE
		Assert.assertEquals(a1, fachada.pesquisarAluno("80911008"));
		// REMOVE ENTIDADE
		fachada.deletarAluno("80911008");
		Assert.assertTrue(fachada.listaTodosAlunos().isEmpty());

	}

	@Test
	public void testCrudDisciplina() {

		Disciplina d1 = new Disciplina();
		d1.setNomeDisciplina("Português");
		d1.setCodigoDisciplina("001");
		Assert.assertTrue(fachada.listaDisciplinas().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarDisciplina(d1);
		Assert.assertFalse(fachada.listaDisciplinas().isEmpty());
		Assert.assertEquals(d1, fachada.pesquisarDisciplina("001"));
		// UPDATE ENTIDADE
		d1.setNomeDisciplina("Matemática");
		fachada.editarDisciplina(d1);
		Assert.assertFalse(fachada.listaDisciplinas().isEmpty());
		Assert.assertEquals("Matemática", fachada.pesquisarDisciplina("001").getNomeDisciplina());
		// GET ENTIDADE
		Assert.assertEquals(d1, fachada.pesquisarDisciplina("001"));
		// REMOVE ENTIDADE
		fachada.deletarDisciplina("001");
		//Assert.assertTrue(fachada.listaDisciplinas().isEmpty());

	}

	@Test
	public void testCrudPratica() {
		
		Pratica p1 = new Pratica();
		p1.setNumeroPratica("001");
		Assert.assertTrue(fachada.listaPraticas().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarPratica(p1);
		Assert.assertFalse(fachada.listaPraticas().isEmpty());
		Assert.assertEquals(p1, fachada.pesquisarPratica("001"));
		// UPDATE ENTIDADE
		p1.setNumeroPratica("001");
		fachada.editarPratica(p1);
		Assert.assertFalse(fachada.listaPraticas().isEmpty());
		Assert.assertEquals("001", fachada.pesquisarPratica("001").getNumeroPratica());
		// GET ENTIDADE
		Assert.assertEquals(p1, fachada.pesquisarPratica("001"));
		// REMOVE ENTIDADE
		fachada.deletarPratica("001");
		//Assert.assertTrue(fachada.getListaPraticas().isEmpty());

	}

	@Test
	public void testCrudProfessor() {

		Professor p1 = new Professor();
		p1.setNome("Francisco");
		p1.setSobrenome("Pinto");
		p1.setCodigo("60");
		p1.setEmail("francisco@dce.ufpb.br");
		p1.setLogin("franciscop");
		p1.setSenha("54321");

		Assert.assertTrue(fachada.listaTodosProfessores().isEmpty());
		
		// CREATE ENTIDADE
		fachada.adicionarProfessor(p1);
		Assert.assertFalse(fachada.listaTodosProfessores().isEmpty());
		Assert.assertEquals(p1, fachada.pesquisarProfessor("60"));
		// UPDATE ENTIDADE
		p1.setNome("joãozinho");
		fachada.editarProfessor(p1);
		Assert.assertFalse(fachada.listaTodosProfessores().isEmpty());
		Assert.assertEquals("joãozinho", fachada.pesquisarProfessor("60").getNome());
		// GET ENTIDADE
		Assert.assertEquals(p1, fachada.pesquisarProfessor("60"));
		// REMOVE ENTIDADE
		fachada.deletarProfessor("60");
		//Assert.assertTrue(fachada.listaTodosProfessores().isEmpty());

	}

	@Test
	public void testCrudTurma() {

		Turma t1 = new Turma();
		t1.setCodigo("001");

		Assert.assertTrue(fachada.listaTurmas().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarTurma(t1);
		Assert.assertFalse(fachada.listaTurmas().isEmpty());
		Assert.assertEquals(t1, fachada.pesquisarTurma("001"));
		// UPDATE ENTIDADE
		t1.setCodigo("001");
		fachada.editarTurma(t1);
		Assert.assertFalse(fachada.listaTurmas().isEmpty());
		Assert.assertEquals("001", fachada.pesquisarTurma("001").getCodigo());
		// GET ENTIDADE
		Assert.assertEquals(t1, fachada.pesquisarTurma("001"));
		// REMOVE ENTIDADE
		fachada.deletarTurma("001");
		//Assert.assertTrue(fachada.getListaTurmas().isEmpty());

	}
	
	@Test
	public void testCrudPergunta() {

		Pergunta p1 = new Pergunta();
		p1.setCodPergunta("001");
		p1.setPergunta("O que você entendeu da aula de hoje?");
		Assert.assertTrue(fachada.listPerguntas().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarPergunta(p1);
		Assert.assertFalse(fachada.listPerguntas().isEmpty());
		Assert.assertEquals(p1, fachada.pesquisarPergunta("001"));
		// UPDATE ENTIDADE
		p1.setCodPergunta("001");
		fachada.editarPergunta(p1);
		Assert.assertFalse(fachada.listPerguntas().isEmpty());
		Assert.assertEquals("001", fachada.pesquisarPergunta("001").getCodPergunta());
		// GET ENTIDADE
		Assert.assertEquals(p1, fachada.pesquisarPergunta("001"));
		// REMOVE ENTIDADE
		fachada.deletarPergunta("001");
		//Assert.assertTrue(fachada.listPerguntas().isEmpty());

	}
	
	@Test
	public void testCrudResposta() {
		
		Resposta r1 = new Resposta();
		r1.setConteudo("Entendi todo o assunto");
		r1.setCodResposta("001");
		Assert.assertTrue(fachada.listaRespostas().isEmpty());
		//CREATE ENTIDADE
		fachada.adicionarRespota(r1);
		Assert.assertFalse(fachada.listaRespostas().isEmpty());
		Assert.assertEquals(r1, fachada.pesquisarResposta("001"));
		// UPDATE ENTIDADE
		r1.setCodResposta("001");
		fachada.editarResposta(r1);
		Assert.assertFalse(fachada.listaRespostas().isEmpty());
		Assert.assertEquals("001", fachada.pesquisarResposta("001").getCodResposta());
		// GET ENTIDADE
		Assert.assertEquals(r1, fachada.pesquisarResposta("001"));
		// REMOVE ENTIDADE
		fachada.deletarRespota("001");
		//Assert.assertTrue(fachada.listaRespostas().isEmpty());
	}
	
	@Test
	public void testCrudUsuário() {
		
		Usuario u1 = new Usuario();
		u1.setNome("José");
		u1.setSobrenome("Maria");
		u1.setEmail("jose.maria@dce.ufpb.br");
		u1.setLogin("josemariajm");
		u1.setSenha("1234");
		Assert.assertTrue(fachada.listaTodosUsuarios().isEmpty());
		//CREATE ENTIDADE
		fachada.adicionarUsuario(u1);
		Assert.assertFalse(fachada.listaTodosUsuarios().isEmpty());
		Assert.assertEquals(u1, fachada.pesquisarUsuario("jose.maria@dce.ufpb.br"));
		// UPDATE ENTIDADE
		u1.setEmail("jose.maria@dce.ufpb.br");
		fachada.editarUsuario(u1);
		Assert.assertFalse(fachada.listaTodosUsuarios().isEmpty());
		Assert.assertEquals("jose.maria@dce.ufpb.br", fachada.pesquisarUsuario("jose.maria@dce.ufpb.br").getEmail());
		// GET ENTIDADE
		Assert.assertEquals(u1, fachada.pesquisarUsuario("jose.maria@dce.ufpb.br"));
		// REMOVE ENTIDADE
		fachada.deletarUsuario(u1);
		//Assert.assertTrue(fachada.listaTodosUsuarios().isEmpty());
	}
	
	@Test
	public void testCrudLogBook() {
		
		LogBook lb1 = new LogBook();
		lb1.setCodLogBook("001");
		lb1.setAssunto("Liguagem de Programação");
		lb1.setData("12/06/2013");
		lb1.setHora("06:30");
		Assert.assertTrue(fachada.listaLogBooks().isEmpty());
		//CREATE ENTIDADE
		fachada.adicionarLogBook(lb1);
		Assert.assertFalse(fachada.listaLogBooks().isEmpty());
		Assert.assertEquals(lb1, fachada.pesquisaLogBook("001"));
		// UPDATE ENTIDADE
		lb1.setCodLogBook("001");
		fachada.editarLogBook(lb1);
		Assert.assertFalse(fachada.listaLogBooks().isEmpty());
		Assert.assertEquals("001", fachada.pesquisaLogBook("001").getCodLogBook());
		// GET ENTIDADE
		Assert.assertEquals(lb1, fachada.pesquisaLogBook("001"));
		// REMOVE ENTIDADE
		fachada.deletarLogBook("001");
		//Assert.assertTrue(fachada.listaTodosUsuarios().isEmpty());
	}
}
