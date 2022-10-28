package it.teorema.gestech.model.mapper;

public class InfoLingue {
	
	int idLingua;
	String nomeLingua;
	String descrizione;
	
	public InfoLingue() {}

	public InfoLingue(int idLingua, String nomeLingua, String descrizione) {
		super();
		this.idLingua = idLingua;
		this.nomeLingua = nomeLingua;
		this.descrizione = descrizione;
	}

	public int getIdLingua() {
		return idLingua;
	}

	public void setIdLingua(int idLingua) {
		this.idLingua = idLingua;
	}

	public String getNomeLingua() {
		return nomeLingua;
	}

	public void setNomeLingua(String nomeLingua) {
		this.nomeLingua = nomeLingua;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}
