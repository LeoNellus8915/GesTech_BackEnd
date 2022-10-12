package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ap_ruoli_persone")
public class RuoliPersone
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "id_ruolo")
	private int idRuolo;
	
	public RuoliPersone() {}

	public RuoliPersone(int id, int idPersona, int idRuolo) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.idRuolo = idRuolo;
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

	public int getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	
}