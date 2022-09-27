package it.teorema.gestech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sy_candidati")
public class Candidati
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nome_cognome")
	private String nomeCognome;
	@Column(name = "cellulare")
	private String cellulare;
	@Column(name = "email")
	private String email;
	@Column(name = "profilo_linkedin")
	private String profiloLinkedin;
	@Column(name = "citta")
	private String citta;
	
	public Candidati() {}

	public Candidati(int id, String nomeCognome, String cellulare, String email, String profiloLinkedin, String citta) {
		super();
		this.id = id;
		this.nomeCognome = nomeCognome;
		this.cellulare = cellulare;
		this.email = email;
		this.profiloLinkedin = profiloLinkedin;
		this.citta = citta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCognome() {
		return nomeCognome;
	}

	public void setNomeCognome(String nomeCognome) {
		this.nomeCognome = nomeCognome;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfiloLinkedin() {
		return profiloLinkedin;
	}

	public void setProfiloLinkedin(String profiloLinkedin) {
		this.profiloLinkedin = profiloLinkedin;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}
}