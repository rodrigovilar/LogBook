package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Resposta;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorResposta {
	
	private List<Resposta> listaRespostas = new ArrayList<Resposta>();
	
	public void adicionarRespota(Resposta novaResposta) {
		listaRespostas.add(novaResposta);
	}
	
	public Resposta editarResposta(Resposta resposta) {
		for (Resposta r : listaRespostas) {
			if (resposta.getCodResposta().equals(r.getCodResposta())) {
				r = resposta;
				listaRespostas.add(r);
				return r;
			}
		}
		throw new Excecao(
				"Não existe está Disciplina com este código no sistema LogBook");
	}
	
	public Resposta pesquisarResposta(String codResposta) {
		Resposta resposta = new Resposta();
		for (Resposta r : listaRespostas) {
			if (r.getCodResposta() == codResposta)
				resposta = r;
			break;
		}
		return resposta;
	}
	
	public void deletarRespota(String codResposta) {
		Resposta resposta = new Resposta();
		resposta = this.pesquisarResposta(codResposta);
		
		if (resposta.getCodResposta() == codResposta){
			this.listaRespostas.remove(resposta);
		}
	} 
	
	public List<Resposta> getListaRespostas() {
		return listaRespostas;
	}

	public void setListaRespostas(List<Resposta> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}
}
