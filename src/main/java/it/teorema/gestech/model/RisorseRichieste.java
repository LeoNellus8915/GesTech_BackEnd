package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sy_risorse_richieste")
public class RisorseRichieste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_risorsa")
	private int idRisorsa;
	@Column(name = "id_richiesta")
	private int idRichiesta;
	@Column(name = "visualizzato")
	private boolean visualizzato;
	
	public RisorseRichieste() {}
	
	public RisorseRichieste(int idRisorsa, int idRichiesta)
	{
		this.idRisorsa = idRisorsa;
		this.idRichiesta = idRichiesta;
	}

	public RisorseRichieste(int id, int idRisorsa, int idRichiesta, boolean visualizzato) {
		super();
		this.id = id;
		this.idRisorsa = idRisorsa;
		this.idRichiesta = idRichiesta;
		this.visualizzato = visualizzato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(int idRisorsa) {
		this.idRisorsa = idRisorsa;
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