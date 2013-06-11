package br.com.ufpb.aps.logbook.controlador;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.fachada.LogbookFachada;

public class teste {
 public static void main(String[]  args){
	 
	 LogbookFachada fachada = new LogbookFachada();
	 
	 Aluno a1 = new Aluno();
		a1.setNome("Luiz Fernando");
		a1.setSobrenome("Paiva");
		a1.setMatricula("80911008");
		a1.setEmail("fernando.paiva@dce.ufpb.br");
		a1.setLogin("fernandopaiva");
		a1.setSenha("12345");

		fachada.adicionarAluno(a1);
 }
}
