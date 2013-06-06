package br.com.ufpb.aps.logbok.gerenciador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbok.entidade.Aluno;
import br.com.ufpb.aps.logbok.entidade.Turma;

public class GerenciadorTurma {
	
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public void adicionarTurma(Turma novaTurma){
		
	}
	public void editarTurma(int Numeroturma){
		
	}
    public List<Turma> listaTodasTurma(){
		return turmas;
    	
    }
    public Turma pesquisarTurma(int numeroDaTurma){//mostar a turma de arcordo com numero que foi passado como paramentro
		return null;
    	
    }
    public Turma deletarTurma(int numeroTurma){
		return null;//deletar a turma pelo numero e retornar a turma que foi excluida 
    	
    }
    //public void adicionarDisicplinaAturma(Turma novaTurma)
}
