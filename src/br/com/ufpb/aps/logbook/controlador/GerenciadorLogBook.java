package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Pratica;
import br.com.ufpb.aps.logbook.entidade.Professor;

public class GerenciadorLogBook {

	private List<Professor> listaTodosProfessores = new ArrayList<Professor>();
	private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	
	//metodo adicionara a nova pratica na lista(GerenciadorPratica)
	public void criarLogBookProfessor(Pratica novaPratica){
		
	}
    public Professor pesquisarProfessor(Professor professor){
		return null;
		
	}
	public Professor deletarProfessor(String nomeProfessor){
		return null;
		
	}
	public List<Professor> getListaTodosProfessores() {
		return listaTodosProfessores;
	}
	
	public void setListaTodosProfessores(List<Professor> listaTodosProfessores) {
		this.listaTodosProfessores = listaTodosProfessores;
	}
	
	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}
	
	public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}
    
    
}