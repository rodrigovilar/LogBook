package br.com.ufpb.aps.logbook.entidade;

public class Pergunta {
	
	private String pergunta;
	private String resposta;
	private String codPergunta;
	
	public Pergunta (String pergunta, String resposta, String codPergunta){
		this.codPergunta = pergunta;
		this.resposta = resposta;
		this.codPergunta = codPergunta;
	}
	public Pergunta() {
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String getCodPergunta() {
		return codPergunta;
	}

	public void setCodPergunta(String codPergunta) {
		codPergunta = codPergunta;
	}
}
