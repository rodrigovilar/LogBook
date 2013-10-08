package br.com.ufpb.aps.logbook.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Persistencia<T> {
	private String nomeArquivo;
	public Persistencia(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
		File f = new File(nomeArquivo);
		if (!f.exists())
			try {
				f.createNewFile();
				List<T> lista = new ArrayList<T>();
				save(lista);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public void save(List<T> lista) {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(nomeArquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(lista);
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<T> read() {
		FileInputStream fin;
		ObjectInputStream ois;
		List<T> lista = new ArrayList<T>();
		try {
			fin = new FileInputStream(nomeArquivo);
			ois = new ObjectInputStream(fin);
			lista = (ArrayList<T>) ois.readObject();
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}
}