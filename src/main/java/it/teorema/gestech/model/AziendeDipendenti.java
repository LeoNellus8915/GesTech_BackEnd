package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sy_aziende_dipendenti")
public class AziendeDipendenti
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_dipendente")
	private int idDipendente;
	@Column(name = "id_azienda")
	private int idAzienda;
	
	public AziendeDipendenti() {}

	public AziendeDipendenti(int id, int idDipendente, int idAzienda) {
		super();
		this.id = id;
		this.idDipendente = idDipendente;
		this.idAzienda = idAzienda;
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

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
}