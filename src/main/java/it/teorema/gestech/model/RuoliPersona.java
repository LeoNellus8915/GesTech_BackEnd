package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_ruoli_persona")
public class RuoliPersona
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "id_ruolo")
	private int idRuolo;
	
	public RuoliPersona() {}

	public RuoliPersona(int id, int idPersona, int idRuolo) {
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

	public int getidPersona() {
		return idPersona;
	}

	public void setidPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}

	
}