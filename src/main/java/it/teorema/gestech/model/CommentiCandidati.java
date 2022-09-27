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
	@Column(name = "id_dipendente")
	private int idDipendente;
	@Column(name = "id_candidato")
	private int idCandidato;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDate data;
	
	public CommentiCandidati() {}

	public CommentiCandidati(int id, int idDipendente, int idCandidato, String note, LocalDate data) {
		super();
		this.id = id;
		this.idDipendente = idDipendente;
		this.idCandidato = idCandidato;
		this.note = note;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
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