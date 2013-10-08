package br.com.ufpb.aps.logbook.entidade;

public class Pergunta {

	private String pergunta;
	private String codPergunta;

	public Pergunta(String pergunta, String codPergunta) {
		this.codPergunta = pergunta;
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

	public String getCodPergunta() {
		return codPergunta;
	}
	public void setCodPergunta(String codPergunta) {
		this.codPergunta = codPergunta;
	}

}
