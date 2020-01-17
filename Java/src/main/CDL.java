package main;

import java.util.ArrayList;

public class CDL {
	private int id;
	private String nome;
	private String descrizione;
	ArrayList<Studente> studenti;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public ArrayList<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<Studente> studenti) {
		this.studenti = studenti;
	}
	
}
