package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sy_dipendenti_richieste")
public class DipendentiRichieste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_dipendente")
	private int idDipendente;
	@Column(name = "id_richiesta")
	private int idRichiesta;
	@Column(name = "visualizzato")
	private boolean visualizzato;
	
	public DipendentiRichieste() {}
	
	public DipendentiRichieste(int idDipendente, int idRichiesta) {
		super();
		this.idDipendente = idDipendente;
		this.idRichiesta = idRichiesta;
	}

	public DipendentiRichieste(int id, int idDipendente, int idRichiesta, boolean visualizzato) {
		super();
		this.id = id;
		this.idDipendente = idDipendente;
		this.idRichiesta = idRichiesta;
		this.visualizzato = visualizzato;
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