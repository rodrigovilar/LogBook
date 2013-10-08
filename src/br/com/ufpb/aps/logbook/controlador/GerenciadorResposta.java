package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Resposta;
import br.com.ufpb.aps.logbook.excecao.RespostaInexistenteException;
import br.com.ufpb.aps.logbook.excecao.RespostaJaCadastradaException;
import br.com.ufpb.aps.logbook.excecao.RespostaSemDadosException;

public class GerenciadorResposta {
	
	private List<Resposta> listaRespostas = new ArrayList<Resposta>();
	
	public void adicionarRespota(Resposta novaResposta) throws RespostaSemDadosException, RespostaJaCadastradaException, RespostaInexistenteException
	{
		if( novaResposta.getCodResposta() == null || novaResposta.getConteudo() == null) 
			
			throw new RespostaSemDadosException ("Impossível adicionar uma resposta sem os Dados!");
	
		try 
		{
			pesquisarResposta(novaResposta.getCodResposta());
			throw new RespostaJaCadastradaException("Já existe resposta cadastrada com o codigo informado!");
			
		} 

		catch (RespostaInexistenteException e) 
		{
			listaRespostas.add(novaResposta);
		}
		
	}
	
	public Resposta editarResposta(Resposta resposta) throws RespostaInexistenteException 
	{
		Resposta resp = pesquisarResposta (resposta.getCodResposta());
		resp.setCodResposta(resposta.getCodResposta());
		resp.setConteudo(resposta.getConteudo());
		return resp;
	}

	public Resposta pesquisarResposta(String codResposta) throws RespostaInexistenteException
	{
		for (Resposta r : listaRespostas) 
		{
			if (r.getCodResposta().equals(codResposta))
				return r;
		}
		throw new RespostaInexistenteException("Não existe esta resposta com este codigo no Sitema LogBook");
	}

	public void deletarRespota(String codResposta) throws RespostaInexistenteException 
	{
		Resposta resp = pesquisarResposta(codResposta);
		listaRespostas.remove(resp);
	} 

	public List<Resposta> getListaRespostas() {
		return listaRespostas;
	}

	public void setListaRespostas(List<Resposta> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}
}
