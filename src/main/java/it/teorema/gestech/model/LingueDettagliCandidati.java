package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "as_lingue_dettagli_candidati")
public class LingueDettagliCandidati {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_dettaglio_candidato")
	private int idDettaglioCandidato;
	@Column(name = "id_lingua")
	private int idLingua;
	@Column(name = "descrizione")
	private String descrizione;
	
	public LingueDettagliCandidati() {}

	public LingueDettagliCandidati(int id, int idDettaglioCandidato, int idLingua, String descrizione) {
		super();
		this.id = id;
		this.idDettaglioCandidato = idDettaglioCandidato;
		this.idLingua = idLingua;
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDettaglioCandidato() {
		return idDettaglioCandidato;
	}

	public void setIdDettaglioCandidato(int idDettaglioCandidato) {
		this.idDettaglioCandidato = idDettaglioCandidato;
	}

	public int getIdLingua() {
		return idLingua;
	}

	public void setIdLingua(int idLingua) {
		this.idLingua = idLingua;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	

}
