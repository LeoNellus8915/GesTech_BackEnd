package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "as_richieste_dettagli_candidati")
public class RichiesteDettagliCandidati {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_richiesta")
	private int idRichiesta;
	@Column(name = "id_dettaglio_candidato")
	private int idDettaglioCandidato;
	@Column(name = "note")
	private String note;
	
	public RichiesteDettagliCandidati() {}

	public RichiesteDettagliCandidati(int id, int idRichiesta, int idDettaglioCandidato) {
		super();
		this.id = id;
		this.idRichiesta = idRichiesta;
		this.idDettaglioCandidato = idDettaglioCandidato;
	}

	public RichiesteDettagliCandidati(int idRichiesta, int idDettaglioCandidato, String note) {
		this.idRichiesta = idRichiesta;
		this.idDettaglioCandidato = idDettaglioCandidato;
		this.note = note;
	}

	public RichiesteDettagliCandidati(int idDettaglioCandidato, int idRichiesta) {
		this.idDettaglioCandidato = idDettaglioCandidato;
		this.idRichiesta = idRichiesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(int idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public int getIdDettaglioCandidato() {
		return idDettaglioCandidato;
	}

	public void setIdDettaglioCandidato(int idDettaglioCandidato) {
		this.idDettaglioCandidato = idDettaglioCandidato;
	}
	
	

}
