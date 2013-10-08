package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Turma;
import br.com.ufpb.aps.logbook.excecao.DisciplinaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.DisciplinaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.DisciplinaSemDadosException;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorDisciplina {

	private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	private List<Turma> listaTurmas = new ArrayList<Turma>();

	public void adicionarDisciplina(Disciplina disciplina) throws DisciplinaSemDadosException, DisciplinaJaCadastradaException 
	{
		if(disciplina.getCodigoDisciplina() == null 
				|| disciplina.getNomeDisciplina() == null 
				|| disciplina.getProfessor() == null)
			throw new DisciplinaSemDadosException("Disciplina sem Dados");
		
		try 
		{
			pesquisarDisciplina(disciplina.getCodigoDisciplina());
			throw new DisciplinaJaCadastradaException("Disciplina já cadastrada");
		} 
		
		catch (DisciplinaInexistenteException e) 
		{
			listaDisciplinas.add(disciplina);
		}
	}

	public Disciplina editarDisciplina(Disciplina disciplina) throws DisciplinaInexistenteException 
	{
		Disciplina d = pesquisarDisciplina(disciplina.getCodigoDisciplina());
		d.setCodigoDisciplina(disciplina.getCodigoDisciplina());
		return d;
	}

	public Disciplina pesquisarDisciplina(String codigoDisciplina) throws DisciplinaInexistenteException 
	{
		for (Disciplina d : listaDisciplinas) 
		{
			if (d.getCodigoDisciplina() == codigoDisciplina) 
			{
				return d;
			}
		}
		
		throw new DisciplinaInexistenteException("A disciplina não foi encontrada no sistema");
	}

	public void deletarDisciplina(String codigoDisciplina) throws DisciplinaInexistenteException 
	{
		Disciplina d = pesquisarDisciplina(codigoDisciplina);
		listaDisciplinas.remove(d);
	}

	public List<Disciplina> listaDisciplinas() {
		return listaDisciplinas;
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
}
