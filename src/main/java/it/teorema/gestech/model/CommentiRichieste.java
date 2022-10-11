package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_commenti_richieste")
public class CommentiRichieste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_dettaglio_candidato")
	private int idDettaglioCandidato;
	@Column(name = "id_richiesta")
	private int idRichiesta;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDateTime data;
	@Column(name = "nascosto")
	private boolean nascosto;
	
	public CommentiRichieste(){}

	public CommentiRichieste(int id, int idDettaglioCandidato, int idRichiesta, String note, LocalDateTime data, boolean nascosto) {
		super();
		this.id = id;
		this.idDettaglioCandidato = idDettaglioCandidato;
		this.idRichiesta = idRichiesta;
		this.note = note;
		this.data = data;
		this.nascosto = nascosto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getidDettaglioCandidato() {
		return idDettaglioCandidato;
	}

	public void setidDettaglioCandidato(int idDettaglioCandidato) {
		this.idDettaglioCandidato = idDettaglioCandidato;
	}

	public int getIdRichiesta() {
		return idRichiesta;
	}

	public void setIdRichiesta(int idRichiesta) {
		this.idRichiesta = idRichiesta;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public boolean isNascosto() {
		return nascosto;
	}

	public void setNascosto(boolean nascosto) {
		this.nascosto = nascosto;
	}
}