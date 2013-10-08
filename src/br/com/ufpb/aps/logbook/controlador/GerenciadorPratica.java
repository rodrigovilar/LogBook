package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorPratica {
	
	//private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	
	private List<Pratica> listaPraticas = new ArrayList<Pratica>();
	
	public void adicionarPraticaProfessor(Pratica novaPratica) {
		listaPraticas.add(novaPratica);
	}

	public Pratica editarPratica(Pratica pratica) {

		for (Pratica p : listaPraticas) {
			if (p.getNumeroPratica().equals(pratica.getNumeroPratica())) {
				p = pratica;
				listaPraticas.add(p);
				return p;
			}
		}
		throw new Excecao(
				"Não existe este aluno com esta matricula no Sitema LogBook");
	}

	public Pratica pesquisarPratica(String numPratica) {
		
		for (Pratica p : listaPraticas) {
			if (p.getNumeroPratica().equalsIgnoreCase(numPratica)) {
				return p;
			}
		}
		throw new Excecao(
				"Não existe este aluno com esta prática no Sitema LogBook");
	}

	public void deletarPratica(String numeroPratica) {
		for (Pratica d : listaPraticas) {
			if (d.getNumeroPratica().equalsIgnoreCase(numeroPratica)) {
				listaPraticas.remove(d);
				return;
			}

		}
		throw new Excecao(
				"Não existe este aluno com esta prática no Sitema LogBook");
	}

	public List<Pratica> getPraticas() {
		return listaPraticas;
	}

	public void setPraticas(List<Pratica> praticas) {
		this.listaPraticas = praticas;
	}

}
