package it.teorema.gestech.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_commenti_risorse")
public class CommentiRisorse
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_mittente")
	private int idMittente;
	@Column(name = "id_destinatario")
	private int idDestinatario;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDate data;
	
	public CommentiRisorse() {}

	public CommentiRisorse(int id, int idMittente, int idDestinatario, String note, LocalDate data) {
		super();
		this.id = id;
		this.idMittente = idMittente;
		this.idDestinatario = idDestinatario;
		this.note = note;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMittente() {
		return idMittente;
	}

	public void setIdMittente(int idMittente) {
		this.idMittente = idMittente;
	}

	public int getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(int idDestinatario) {
		this.idDestinatario = idDestinatario;
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