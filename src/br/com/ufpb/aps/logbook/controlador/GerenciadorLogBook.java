package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.LogBook;
import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorLogBook {

	private List<LogBook> listaLogBooks = new ArrayList<LogBook>();
	
	public void adicionarLogBook(LogBook logbook) {
		listaLogBooks.add(logbook);
	}
	
	public LogBook editarLogBook(LogBook logbook) {
		for (LogBook lb : listaLogBooks) {
			if (logbook.getCodLogBook().equals(lb.getCodLogBook())) {
				lb = logbook;
				listaLogBooks.add(lb);
				return lb;
			}
		}
		throw new Excecao(
				"Não existe está Disciplina com este código no sistema LogBook");
	}
	
	public List<LogBook> listaLogBooks() {
		return listaLogBooks;
	}

	public void setListaLogBooks(List<LogBook> listaLogBooks) {
		this.listaLogBooks = listaLogBooks;
	}
}