package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.entidade.Resposta;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorPratica {

	private List<Pratica> listaPraticas = new ArrayList<Pratica>();
	private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

	public void adicionarPraticaProfessor(Pratica novaPratica) {
		listaPraticas.add(novaPratica);
	}

	public Pratica editarPratica(Pratica pratica) {

		for (Pratica d : listaPraticas) {
			if (d.getNumeroPratica().equals(pratica.getNumeroPratica())) {
				d = pratica;
				listaPraticas.add(d);
				return d;
			}
		}
		throw new Excecao(
				"Não existe este aluno com esta matricula no Sitema LogBook");
	}

	public Pratica pesquisarPratica(String pratica) {
		for (Pratica d : listaPraticas) {
			if (d.getNumeroPratica().equalsIgnoreCase(pratica)) {
				return d;
			}

		}
		throw new Excecao(
				"Não existe este aluno com esta matricula no Sitema LogBook");
	}

	public void deletarPratica(String numeroPratica) {
		for (Pratica d : listaPraticas) {
			if (d.getNumeroPratica().equalsIgnoreCase(numeroPratica)) {
				listaPraticas.remove(d);
				return;
			}

		}
		throw new Excecao(
				"Não existe este aluno com esta matricula no Sitema LogBook");
	}

	public List<Pratica> getPraticas() {
		return listaPraticas;
	}

	public void setPraticas(List<Pratica> praticas) {
		this.listaPraticas = praticas;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplinas;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplinas = listaDisciplina;
	}
}
