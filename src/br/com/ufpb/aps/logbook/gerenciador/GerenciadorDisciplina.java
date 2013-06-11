package br.com.ufpb.aps.logbook.gerenciador;

import java.util.ArrayList;
import java.util.List;

//import br.com.ufpb.aps.logbok.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Disciplina;

public class GerenciadorDisciplina {
	
	private List<Disciplina> disciplina = new ArrayList<Disciplina>();
	
	public void adicionarDisciplina(Disciplina disciplina){
		
	}
	
	public void editarDisciplina(List<Disciplina> disciplina){
		
	}
   
	public List<Disciplina> listaTodasDisciplinas(){
		return disciplina;
    	
    }
    public Disciplina pesquisarDisciplina(List<Disciplina> pesDisciplina){// retonara uma unica disciplina que a pessoa desejou
		return null;
		
    	
    }
    public Disciplina deletarDisciplina(List<Disciplina> pesDisicplina){
		return null;// excluir e retonar a disciplina que foi deletada
    	
    }
    
}
