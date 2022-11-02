package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "as_profili_dettagli_candidati")
public class ProfiliDettagliCandidati {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_dettaglio_candidato")
	private int idDettaglioCandidato;
	@Column(name = "id_profilo")
	private int idProfilo;
	@Column(name = "id_livello")
	private int idLivello;
	@Column(name = "id_linguaggio")
	private int idLinguaggio;
	@Column(name = "descrizione")
	private String descrizione;
	
	public ProfiliDettagliCandidati() {}
	
	public ProfiliDettagliCandidati(int idDettaglioCandidato) {
		this.idDettaglioCandidato = idDettaglioCandidato;
	}

	public ProfiliDettagliCandidati(int id, int idDettaglioCandidato, int idProfilo, int idLivello, int idLinguaggio,
			String descrizione) {
		super();
		this.id = id;
		this.idDettaglioCandidato = idDettaglioCandidato;
		this.idProfilo = idProfilo;
		this.idLivello = idLivello;
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
	
	public int getIdLivello() {
		return idLivello;
	}

	public void setIdLivello(int idLivello) {
		this.idLivello = idLivello;
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

	public void setProfiloDefault(int idProfilo, int idLivello, int idLinguaggio) {
		this.idProfilo = idProfilo;
		this.idLivello = idLivello;
		this.idLinguaggio = idLinguaggio;
	}
	
	

}
