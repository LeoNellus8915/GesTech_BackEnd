package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="as_richieste_persone")
public class RichiestePersone
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "id_richiesta")
	private int idRichiesta;
	@Column(name = "visualizzato")
	private boolean visualizzato;
	
	public RichiestePersone() {}
	
	public RichiestePersone(int id, int idPersona, int idRichiesta, boolean visualizzato) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.idRichiesta = idRichiesta;
		this.visualizzato = visualizzato;
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
	public boolean isVisualizzato() {
		return visualizzato;
	}
	public void setVisualizzato(boolean visualizzato) {
		this.visualizzato = visualizzato;
	}
}