package br.com.ufpb.aps.logbook.controlador;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.aps.logbook.entidade.Aluno;
import br.com.ufpb.aps.logbook.excecao.AlunoInexistenteException;
import br.com.ufpb.aps.logbook.excecao.AlunoJaCadastradoException;
import br.com.ufpb.aps.logbook.excecao.AlunoSemDadosException;
import br.com.ufpb.aps.logbook.persistencia.Persistencia;

public class GerenciadorAluno {
	private List<Aluno> listaTodosAlunos;
	private Persistencia<Aluno> persistencia;
	public GerenciadorAluno() {
		persistencia = new Persistencia<Aluno>("alunos.txt");
		listaTodosAlunos = new ArrayList<Aluno>();
	}
	public void adicionarAluno(Aluno aluno) throws AlunoSemDadosException,
			AlunoJaCadastradoException, AlunoInexistenteException {
		if (aluno.getMatricula() == null || aluno.getNome() == null
				|| aluno.getEmail() == null || aluno.getLogin() == null
				|| aluno.getSenha() == null)
			throw new AlunoSemDadosException(
					"Imposs�vel adicionar aluno sem dados!");
		try {
			pesquisarAluno(aluno.getMatricula());
			throw new AlunoJaCadastradoException(
					"J� existe aluno cadastrado com a matr�cula informada!");
		} catch (AlunoInexistenteException e1) {
			listaTodosAlunos.add(aluno);
			persistencia.save(listaTodosAlunos);
		}
	}
	public Aluno editarDadosAluno(Aluno aluno) throws AlunoInexistenteException {
		Aluno a = pesquisarAluno(aluno.getMatricula());
		a.setEmail(aluno.getEmail());
		a.setLogin(aluno.getLogin());
		a.setNome(aluno.getNome());
		a.setSobrenome(aluno.getSobrenome());
		a.setSenha(aluno.getSenha());
		persistencia.save(listaTodosAlunos);
		return a;
	}
	public Aluno pesquisarAluno(String matricula)
			throws AlunoInexistenteException {
		for (Aluno aluno : listaTodosAlunos) {
			if (aluno.getMatricula().equals(matricula))
				return aluno;
		}
		throw new AlunoInexistenteException(
				"N�o existe este aluno com esta matricula no Sitema LogBook");
	}
	public void deletarAluno(String matricula) throws AlunoInexistenteException {
		Aluno a = pesquisarAluno(matricula);
		listaTodosAlunos.remove(a);
		persistencia.save(listaTodosAlunos);
	}
	public List<Aluno> getListaTodosAlunos() {
		return listaTodosAlunos;
	}
}