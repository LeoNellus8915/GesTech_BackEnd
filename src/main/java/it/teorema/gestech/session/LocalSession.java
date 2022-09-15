package it.teorema.gestech.session;

public class LocalSession {
	private String nomeCognome;
	private String ruolo;
	private String azienda;
	private int idRisorsa;
	private int numeroRichieste;
	
	public String getNomeCognome() {
		return nomeCognome;
	}
	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public String getAzienda() {
		return azienda;
	}
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	public int getIdRisorsa() {
		return idRisorsa;
	}
	public void setIdRisorsa(int idRisorsa) {
		this.idRisorsa = idRisorsa;
	}
	public int getNumeroRichieste() {
		return numeroRichieste;
	}
	public void setNumeroRichieste(int numeroRichieste) {
		this.numeroRichieste = numeroRichieste;
	}
}