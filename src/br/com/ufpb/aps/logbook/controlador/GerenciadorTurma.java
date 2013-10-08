package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.entidade.Turma;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorTurma {

	private List<Turma> listaTurmas = new ArrayList<Turma>();
	
	public void adicionarTurma(Turma novaTurma) {
		listaTurmas.add(novaTurma);
	}
	
	public Turma editarTurma(Turma turma) {
		for (Turma t : listaTurmas){
			if (turma.getCodigo().equals(t.getCodigo())) {
				t = turma;
				listaTurmas.add(t);
				return t;
			}
		}
		throw new Excecao("Não existe Turma com este código no sistema LogBook");
	}

	public List<Turma> listaTodasTurma() {
		return getListaTurmas();

	}

	public Turma pesquisarTurma(String codigoTurma) {
		Turma turma = new Turma();
		for (Turma t : listaTurmas) {
			if (t.getCodigo() == codigoTurma) {
				turma = t;
				break;
			}
		}
		return turma;
	}

	public void deletarTurma(String codigoTurma) {
		for( Turma t : this.listaTurmas ){
			if (t.getCodigo() == codigoTurma) {
				this.listaTurmas.remove(t);
			}
		}
				
		//listaTurmas.remove(codigoTurma);
	}

	public List<Turma> getListaTurmas() {
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
	
	
}
