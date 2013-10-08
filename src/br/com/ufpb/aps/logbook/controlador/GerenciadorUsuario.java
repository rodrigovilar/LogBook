package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.entidade.Disciplina;
import br.com.ufpb.aps.logbook.entidade.Professor;
import br.com.ufpb.aps.logbook.entidade.Resposta;
import br.com.ufpb.aps.logbook.entidade.Usuario;
import br.com.ufpb.aps.logbook.excecao.Excecao;

public class GerenciadorUsuario {

	private List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();

	public void adicionarUsuario(Usuario novoUsuario) {
		listaTodosUsuarios.add(novoUsuario);
	}

	public void deletarUsuario(Usuario usuario) {
			for (Usuario u : listaTodosUsuarios) {		
				if (u.getEmail().equals(u.getEmail())) {
					listaTodosUsuarios.remove(u);				
					return;
				}
			}
	}

	public Usuario pesquisarUsuario(String email){
		Usuario usuario = new Usuario();
		for (Usuario u : listaTodosUsuarios){
			if(u.getEmail().equalsIgnoreCase(email)){
				usuario = u;
			}
			return usuario;
		}
		throw new Excecao("Não existe usuario com este email no Sitema LogBook");
	}

	public Usuario editarUsuario(Usuario usuario) {
		for(Usuario u: listaTodosUsuarios){
			if(usuario.getEmail().equals(u.getEmail())){
				u = usuario;
				listaTodosUsuarios.add(u);
				return u;
			}
		}
		throw new Excecao("Não existe usuário com este e-mail no sistema LogBook");
	}

	public List<Usuario> getListaTodosUsuarios() {
		return listaTodosUsuarios;
	}

	public void setListaTodosUsuarios(List<Usuario> listaTodosUsuarios) {
		this.listaTodosUsuarios = listaTodosUsuarios;
	}

}
