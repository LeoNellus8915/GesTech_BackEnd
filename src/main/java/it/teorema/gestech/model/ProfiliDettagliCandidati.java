package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hy_profili_dettagli_candidati")
public class ProfiliDettagliCandidati {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_dettaglio_candidato")
	private int idDettaglioCandidato;
	@Column(name = "id_profilo")
	private int idProfilo;
	@Column(name = "id_livelli")
	private int idLivelli;
	@Column(name = "id_linguaggio")
	private int idLinguaggio;
	@Column(name = "descrizione")
	private String descrizione;
	
	private ProfiliDettagliCandidati() {}

	public ProfiliDettagliCandidati(int id, int idDettaglioCandidato, int idProfilo, int idLivelli, int idLinguaggio,
			String descrizione) {
		super();
		this.id = id;
		this.idDettaglioCandidato = idDettaglioCandidato;
		this.idProfilo = idProfilo;
		this.idLivelli = idLivelli;
		this.idLinguaggio = idLinguaggio;
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

	public int getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	public int getIdLivelli() {
		return idLivelli;
	}

	public void setIdLivelli(int idLivelli) {
		this.idLivelli = idLivelli;
	}

	public int getIdLinguaggio() {
		return idLinguaggio;
	}

	public void setIdLinguaggio(int idLinguaggio) {
		this.idLinguaggio = idLinguaggio;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	

}
