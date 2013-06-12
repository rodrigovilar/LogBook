package br.com.ufpb.aps.logbook.testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.entidade.Turma;
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
	public void testCrudDisciplina() {
		
		Disciplina d1 = new Disciplina();
		d1.setNomeDisciplina("Português");
		d1.setCodigoDisciplina("001");
	
		Assert.assertTrue(fachada.listaTodosProfessores().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarDisciplina(d1);
		Assert.assertFalse(fachada.getListaDisciplinas().isEmpty());
		Assert.assertEquals(d1, fachada.pesquisarDisciplina("001"));
		// UPDATE ENTIDADE
		d1.setNomeDisciplina("Matemática");
		fachada.editarDisciplina(d1);
		Assert.assertFalse(fachada.getListaDisciplinas().isEmpty());
		Assert.assertEquals("Matemática", fachada.pesquisarDisciplina("001")
				.getNomeDisciplina());
		// GET ENTIDADE
		Assert.assertEquals(d1, fachada.pesquisarDisciplina("001"));
		// REMOVE ENTIDADE
		fachada.deletarDisciplina("001");
		//Assert.assertTrue(fachada.getListaDisciplinas().isEmpty());
	}

	@Test
	public void testCrudTurma() {
		
		Turma t1 = new Turma();
		t1.setCodigo("001");
		Assert.assertTrue(fachada.getListaTurmas().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarTurma(t1);
		Assert.assertFalse(fachada.getListaTurmas().isEmpty());
		Assert.assertEquals(t1, fachada.pesquisarTurma("001"));
		// UPDATE ENTIDADE
		t1.setCodigo("001");
		fachada.editarTurma(t1);
		Assert.assertFalse(fachada.getListaTurmas().isEmpty());
		Assert.assertEquals("001", fachada.pesquisarTurma("001").getCodigo());
		// GET ENTIDADE
		Assert.assertEquals(t1, fachada.pesquisarTurma("001"));
		// REMOVE ENTIDADE
		fachada.deletarTurma("001");
		Assert.assertTrue(fachada.getListaDisciplinas().isEmpty());
	}

	@Test
	public void testeCrudPratica(){
		
		
		
	}
	@Ignore
	public void testCrud() {
		
		List<Turma> turma1 = new ArrayList<Turma>();
		Turma t1 = new Turma();
		t1.setCodigo("001");
		Assert.assertTrue(fachada.getListaTurmas().isEmpty());
		// CREATE ENTIDADE
		fachada.adicionarTurma(t1);
		Assert.assertFalse(fachada.getListaTurmas().isEmpty());
		Assert.assertEquals(t1, fachada.pesquisarTurma("001"));
		// UPDATE ENTIDADE
		t1.setCodigo("001");
		fachada.editarTurma(t1);
		Assert.assertFalse(fachada.getListaTurmas().isEmpty());
		Assert.assertEquals("001", fachada.pesquisarTurma("001").getCodigo());
		// GET ENTIDADE
		Assert.assertEquals(t1, fachada.pesquisarTurma("001"));
		// REMOVE ENTIDADE
		fachada.deletarTurma("001");
		// Assert.assertTrue(fachada.getListaDisciplinas().isEmpty());
	}
	
	// inserir Aluno - OK
	// inserir Professor - OK
	// inserir Disciplina - OK
	// inserir Turma - OK
	// Verificar se existe Aluno - OK
	// Verificar se existe Professor - OK
	// Verificar se existe Disciplina - OK
	// Verificar se existe Turma - OK
	// Verificar se Turma tem Disciplina, Professor e Aluno
	// Verificar se Aluno tem Turma Disciplina e Professor
	// Verificar se Professor tem Aluno, Disciplina e Turma
	// Verificar se Disciplina tem Aluno, Turma, Professor
	// Verificar se Aluno consegue escrever no LogBook (Responder a Pergunta: -
	// O que aprendi hoje na aula? / - Quais sï¿½o minhas dï¿½vidas nessa aula?)
	// Verificar se Professor consegue escrever a Prï¿½tica
	// Verificar se Aluno consegue editar Perfil
	// Verificar se Professor consegue editar Perfil
	// Verificar se Professor consegue vizualizar o que o aluno escreveu no
	// Logbook
	// Verificar se Professor consegue corigir as Prï¿½ticas
	// Verificar se Professor consegue Adicionar Aluno
	// Verificar se Professor consegue Deletar Aluno
	// Verificar se Professor consegue Criar Turma
	// Verificar se Professor consegue criar Disciplina
	// Verificar se Professor consegue Deletar Turma
	// VErificar se Professor consegue Deletar Disciplina
	//
}
