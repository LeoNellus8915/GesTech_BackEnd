package it.teorema.gestech.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_commenti_candidati")
public class CommentiCandidati
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "id_dettaglio_candidato")
	private int idDettaglioCandidato;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDate data;
	
	public CommentiCandidati() {}

	public CommentiCandidati(int id, int idPersona, int idDettaglioCandidato, String note, LocalDate data) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.idDettaglioCandidato = idDettaglioCandidato;
		this.note = note;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getidPersona() {
		return idPersona;
	}

	public void setidPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getidDettaglioCandidato() {
		return idDettaglioCandidato;
	}

	public void setidDettaglioCandidato(int idDettaglioCandidato) {
		this.idDettaglioCandidato = idDettaglioCandidato;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}