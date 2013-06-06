package br.com.ufpb.aps.logbok.gerenciador;


import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbok.entidade.Aluno;
import br.com.ufpb.aps.logbok.entidade.Pratica;

public class GerenciadorPratica {

	private List<Pratica> praticas = new ArrayList<Pratica>();// foram criadas varias listas, mas deve ser criadas apenas uma para todos as classes trabalharem
	
	public void adicionarPraticaProfessor(Pratica novaPratica){//o professor ira criar uma nova atividade
		
	}
	public void editarPraticaAluno(List<Pratica> pratica){//o aluno só faz responder a atividade
		
	}
	public List<Pratica> pesquisarPratica(Aluno aluno){
		return praticas;
		
	}
	public List<Pratica> deletarPratica(int numeroPratica){
		return praticas;
		
	}
}
