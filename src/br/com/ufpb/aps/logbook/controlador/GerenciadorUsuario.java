package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Usuario;
import br.com.ufpb.aps.logbook.excecao.UsuarioInexistenteException;
import br.com.ufpb.aps.logbook.excecao.UsuarioJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.UsuarioSemDadosException;

public class GerenciadorUsuario {

	private List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();

	public void adicionarUsuario(Usuario novoUsuario) throws UsuarioSemDadosException, UsuarioJaCadastradoException 
	{
		if(novoUsuario.getEmail() == null 
				|| novoUsuario.getCodigo() == null
				|| novoUsuario.getLogin() == null
				|| novoUsuario.getEmail() == null
				|| novoUsuario.getNome() == null 
				|| novoUsuario.getSenha() == null 
				|| novoUsuario.getSobrenome() == null)
		
				throw new UsuarioSemDadosException ("Usuarios sem dados");
			
		try 
		{
			pesquisarUsuario(novoUsuario.getCodigo());
			throw new UsuarioJaCadastradoException("Já existe usuário cadastrado com o código informado!");
		}
		
		catch (UsuarioInexistenteException e1 )
		{
			listaTodosUsuarios.add(novoUsuario);	
		}
	}

	public Usuario pesquisarUsuario (String codigo) throws UsuarioInexistenteException 
	{
		for (Usuario usuario : listaTodosUsuarios)
		{
			if(usuario.getCodigo().equals(codigo))
				return usuario;
		}
		
		throw new UsuarioInexistenteException("Não existe usuario com este codigo no Sitema LogBook");
	}
	
	public Usuario editarDadosUsuario(Usuario usuario) throws UsuarioInexistenteException 
	{
		Usuario u = pesquisarUsuario(usuario.getCodigo());
		u.setEmail(u.getEmail());
		u.setLogin(u.getLogin());
		u.setNome(u.getNome());
		u.setSenha(u.getSenha());
		u.setSobrenome(u.getSobrenome());
		return u;
	}
	
	public void deletarUsuario(String codigo) throws UsuarioInexistenteException 
	{
		Usuario u = pesquisarUsuario(codigo); 
		listaTodosUsuarios.remove(u);
	}

	public List<Usuario> getListaTodosUsuarios() 
	{
		return listaTodosUsuarios;
	}

}