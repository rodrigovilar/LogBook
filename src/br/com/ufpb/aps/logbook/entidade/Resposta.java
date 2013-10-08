package br.com.ufpb.aps.logbook.entidade;

public class Resposta {
	private String conteudo;
	private String codResposta;
	public Resposta(String conteudo, String codResposta) {
		this.conteudo = conteudo;
		this.setCodResposta(codResposta);
	}
	public Resposta() {
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getCodResposta() {
		return codResposta;
	}
	public void setCodResposta(String codResposta) {
		this.codResposta = codResposta;
	}
}
