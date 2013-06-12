package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.LogBook;
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
	
	public LogBook pesquisarLogBook(String codigoLogBook) {
		LogBook logbook = new LogBook();
		for (LogBook lb : listaLogBooks) {
			if (lb.getCodLogBook() == codigoLogBook)
				logbook = lb;
			break;
		}
		return logbook;
	}

	public void deletarLogBook(String codigoLogBook) {
		LogBook logbook = new LogBook();
		logbook = this.pesquisarLogBook(codigoLogBook);
	
		if (logbook.getCodLogBook() == codigoLogBook){
			this.listaLogBooks().remove(logbook);
		}
	}
	
	public List<LogBook> listaLogBooks() {
		return listaLogBooks;
	}

	public void setListaLogBooks(List<LogBook> listaLogBooks) {
		this.listaLogBooks = listaLogBooks;
	}
}