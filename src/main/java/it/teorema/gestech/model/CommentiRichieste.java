package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ms_commenti_richieste")
public class CommentiRichieste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "id_richiesta")
	private int idRichiesta;
	@Column(name = "note")
	private String note;
	@Column(name = "data")
	private LocalDateTime data;
	@Column(name = "nascosto")
	private boolean nascosto;
	
	public CommentiRichieste(){}

	public CommentiRichieste(int id, int idPersona, int idRichiesta, String note, LocalDateTime data, boolean nascosto) {
		super();
		this.id = id;
		this.idPersona = idPersona;
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

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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