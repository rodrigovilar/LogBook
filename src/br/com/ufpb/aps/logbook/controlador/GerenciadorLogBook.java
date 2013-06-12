package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.LogBook;
import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.entidade.Professor;

public class GerenciadorLogBook {

	private List<LogBook> listaLogBooks = new ArrayList<LogBook>();

	public List<LogBook> getListaLogBooks() {
		return listaLogBooks;
	}

	public void setListaLogBooks(List<LogBook> listaLogBooks) {
		this.listaLogBooks = listaLogBooks;
	}
}