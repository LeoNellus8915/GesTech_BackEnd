package it.teorema.gestech.model.mapper;

import java.time.LocalDate;

public class AllCommentiCandidato {
	
	LocalDate data;
	String nome;
	String cognome;
	String note;
	
	public AllCommentiCandidato() {}
	
	public AllCommentiCandidato(LocalDate data, String nome, String cognome, String note) {
		super();
		this.data = data;
		this.nome = nome;
		this.cognome = cognome;
		this.note = note;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}