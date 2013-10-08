package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.excecao.ProfessorInexistenteException;
import br.com.ufpb.aps.logbook.excecao.ProfessorJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.ProfessorSemDadosException;

public class GerenciadorProfessor {

	private List<Professor> listaProfessores = new ArrayList<Professor>();

	public void adicionarProfessor(Professor professor) throws ProfessorSemDadosException, ProfessorJaCadastradoException, ProfessorInexistenteException 
	{
		if (professor.getNome() == null 
				|| professor.getSobrenome() == null
				|| professor.getEmail() == null
				|| professor.getCodigo() == null
				|| professor.getLogin() == null 
				|| professor.getSenha() == null)
			
			throw new ProfessorSemDadosException ("Imposs�vel adicionar professor sem dados");
		
		try 
		{
			pesquisarProfessor(professor.getCodigo());
			throw new ProfessorJaCadastradoException("J� existe um professor cadastrado com o c�digo informado!");
		}
		
		catch (ProfessorInexistenteException e1) 
		{
			listaProfessores.add(professor);
		}
	}
	
	public Professor pesquisarProfessor(String codigo) throws ProfessorInexistenteException 
	{
		for (Professor p : listaProfessores) 
		{
			if (p.getCodigo().equals(codigo));
			return p;
		}
		
		throw new ProfessorInexistenteException("N�o existe professor com este c�digo no Sitema LogBook");
	}

	public Professor editarDadosProfessor(Professor professor) throws ProfessorInexistenteException 
	{
		Professor p = pesquisarProfessor(professor.getCodigo());
		p.setEmail(p.getEmail());
		p.setLogin(p.getLogin());
		p.setNome(p.getNome());
		p.setSenha(p.getSenha());
		p.setSobrenome(p.getSobrenome());
		
		return p;
	}

	public void deletarProfessor(String codigo) throws ProfessorInexistenteException 
	{
		Professor p = pesquisarProfessor(codigo);
		listaProfessores.remove(p);
	}

	public List<Professor> getlistaTodosProfessores() 
	{
		return listaProfessores;
	}
}
