package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.LogBook;
import br.com.ufpb.aps.logbook.excecao.LogBookInexistenteException;
import br.com.ufpb.aps.logbook.excecao.LogBookJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.LogBookSemDadosException;

public class GerenciadorLogBook {

	private List<LogBook> listaLogBooks = new ArrayList<LogBook>();
	
	public void adicionarLogBook(LogBook logbook) throws LogBookSemDadosException, LogBookJaCadastradoException 
	{
		if(logbook.getCodLogBook() == null 
				|| logbook.getAssunto() == null 
				|| logbook.getHora() == null 
				|| logbook.getData() == null
				|| logbook.getProfessor() == null
				|| logbook.getTurma() == null
				|| logbook.getDisciplina() == null
				|| logbook.getListaPergunta() == null
				|| logbook.getListaPratica() == null
				|| logbook.getListaResposta() == null)
			
				throw new LogBookSemDadosException ("Imposs�vel adicionar LogBook sem dados!");
		try
		{
			pesquisarLogBook(logbook.getCodLogBook());
			throw new LogBookJaCadastradoException("J� existe um LogBook cadastrado com o c�digo informado!");
		}
		
		catch (LogBookInexistenteException e1)
		{
			listaLogBooks.add(logbook);
		}
	}
	
	public LogBook editarLogBook(LogBook logbook) throws LogBookInexistenteException 
	{
		LogBook lb = pesquisarLogBook(logbook.getCodLogBook());
		lb.setAssunto(logbook.getAssunto());
		lb.setHora(logbook.getHora());
		lb.setData(logbook.getData());
		lb.setProfessor(logbook.getProfessor());
		lb.setTurma(logbook.getTurma());
		lb.setDisciplina(logbook.getDisciplina());
		lb.setListaPergunta(logbook.getListaPergunta());
		lb.setListaPratica(logbook.getListaPratica());
		lb.setListaResposta(logbook.getListaResposta());
		
		return lb;
	}
	
	public LogBook pesquisarLogBook(String codigoLogBook) throws LogBookInexistenteException 
	{
		
		for (LogBook lb : listaLogBooks) 
		{
			if (lb.getCodLogBook().equals(codigoLogBook))
				return lb;
		}
		throw new LogBookInexistenteException("N�o existe este LogBook com este c�digo no Sitema LogBook");
	}

	public void deletarLogBook(String codigoLogBook) throws LogBookInexistenteException 
	{
		LogBook lb = pesquisarLogBook(codigoLogBook);
		listaLogBooks.remove(lb);
		
	}
	
	public List<LogBook> listaLogBooks() {
		return listaLogBooks;
	}

	public void setListaLogBooks(List<LogBook> listaLogBooks) {
		this.listaLogBooks = listaLogBooks;
	}
}