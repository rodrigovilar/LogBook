package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.entidade.Usuario;

public class GerenciadorUsuario {

	private List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();

	public void adicionarUsuario(Usuario novoUsuario) {
		listaTodosUsuarios.add(novoUsuario);
	}

	public void deletarUsuario(Usuario usuario) {
		listaTodosUsuarios.remove(usuario);
	}

	// Pegar os métodos de pesquisaAluno e pesquisaProfessor que estão dentro de
	// seus respectivos gerenciadores e verificar se o código ou a matrícula
	// passado está correto para comparar e poder deletar
	public Usuario pesquisarUsuario(String codigo, String matricula){
		for (Usuario u : listaTodosUsuarios){
			
		}
		return null;
	}

	public List<Usuario> getListaTodosUsuarios() {
		return listaTodosUsuarios;
	}

	public void setListaTodosUsuarios(List<Usuario> listaTodosUsuarios) {
		this.listaTodosUsuarios = listaTodosUsuarios;
	}

}
