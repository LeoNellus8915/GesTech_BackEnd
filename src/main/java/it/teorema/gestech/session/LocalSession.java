package it.teorema.gestech.session;

import java.util.List;

public class LocalSession {
	private String nome;
	private String cognome;
	private List<String> ruolo;
	private String azienda;
	private int idDipendente;
	private int numeroRichieste;
	private String token;
	
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
	public List<String> getRuolo() {
		return ruolo;
	}
	public void setRuolo(List<String> ruolo) {
		this.ruolo = ruolo;
	}
	public String getAzienda() {
		return azienda;
	}
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	public int getIdDipendente() {
		return idDipendente;
	}
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	public int getNumeroRichieste() {
		return numeroRichieste;
	}
	public void setNumeroRichieste(int numeroRichieste) {
		this.numeroRichieste = numeroRichieste;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	 
}