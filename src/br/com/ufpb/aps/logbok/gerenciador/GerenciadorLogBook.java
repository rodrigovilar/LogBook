package br.com.ufpb.aps.logbok.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbok.entidade.Pratica;
import br.com.ufpb.aps.logbok.entidade.Professor;

public class GerenciadorLogBook {

	private List<Professor> professores = new ArrayList<Professor>();
	
	//metodo adicionara a nova pratica na lista(GerenciadorPratica)
	public void criarLogBookProfessor(Pratica novaPratica){
		
	}
    public Professor pesquisarProfessor(Professor professor){
		return null;
		
	}
	public Professor deletarProfessor(String nomeProfessor){
		return null;
		
	}
    public List<Professor> listaTodosProfessores(){
		return professores;
    	
    }
}