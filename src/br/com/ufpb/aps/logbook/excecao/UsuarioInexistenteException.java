package br.com.ufpb.aps.logbook.excecao;

public class UsuarioInexistenteException extends Exception {
	public UsuarioInexistenteException(String message) {
		super(message);
	}
}
