package it.teorema.gestech.model.mapper;

public class InfoProfili {
	int idProfilo;
	String nomeProfilo;
	int idLinguaggio;
	String nomeLinguaggio;
	int idLivello;
	String nomeLivello;
	String descrizione;
	
	public InfoProfili() {}

	public InfoProfili(int idProfilo, String nomeProfilo, int idLinguaggio, String nomeLinguaggio, int idLivello,
			String nomeLivello, String descrizione) {
		super();
		this.idProfilo = idProfilo;
		this.nomeProfilo = nomeProfilo;
		this.idLinguaggio = idLinguaggio;
		this.nomeLinguaggio = nomeLinguaggio;
		this.idLivello = idLivello;
		this.nomeLivello = nomeLivello;
		this.descrizione = descrizione;
	}

	public int getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	public String getNomeProfilo() {
		return nomeProfilo;
	}

	public void setNomeProfilo(String nomeProfilo) {
		this.nomeProfilo = nomeProfilo;
	}

	public int getIdLinguaggio() {
		return idLinguaggio;
	}

	public void setIdLinguaggio(int idLinguaggio) {
		this.idLinguaggio = idLinguaggio;
	}

	public String getNomeLinguaggio() {
		return nomeLinguaggio;
	}

	public void setNomeLinguaggio(String nomeLinguaggio) {
		this.nomeLinguaggio = nomeLinguaggio;
	}

	public int getIdLivello() {
		return idLivello;
	}

	public void setIdLivello(int idLivello) {
		this.idLivello = idLivello;
	}

	public String getNomeLivello() {
		return nomeLivello;
	}

	public void setNomeLivello(String nomeLivello) {
		this.nomeLivello = nomeLivello;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
