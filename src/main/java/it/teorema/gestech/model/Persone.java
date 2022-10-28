package it.teorema.gestech.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

@Entity
@Table(name = "hr_persone")
public class Persone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "codice_fiscale")
	private String codiceFiscale;
	@Column(name = "email")
	private String email;
	@Column(name = "cellulare")
	private String cellulare;
	@Column(name = "data_di_nascita")
	private LocalDate dataDiNascita;
	@Column(name = "citta_di_nascita")
	private String cittaDiNascita;
	@Column(name = "citta_di_residenza")
	private String cittaDiResidenza;
	@Column(name = "indirizzo_di_residenza")
	private String indirizzoDiResidenza;
	@Column(name = "cap_di_residenza")
	private int capDiResidenza;
	
	
	public Persone() {}

	public Persone(int id, String nome, String cognome, String codiceFiscale, String email, String cellulare,
			LocalDate dataDiNascita, String cittaDiNascita, String cittaDiResidenza, String indirizzoDiResidenza,
			int capDiResidenza) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.email = email;
		this.cellulare = cellulare;
		this.dataDiNascita = dataDiNascita;
		this.cittaDiNascita = cittaDiNascita;
		this.cittaDiResidenza = cittaDiResidenza;
		this.indirizzoDiResidenza = indirizzoDiResidenza;
		this.capDiResidenza = capDiResidenza;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getCittaDiNascita() {
		return cittaDiNascita;
	}

	public void setCittaDiNascita(String cittaDiNascita) {
		this.cittaDiNascita = cittaDiNascita;
	}

	public String getCittaDiResidenza() {
		return cittaDiResidenza;
	}

	public void setCittaDiResidenza(String cittaDiResidenza) {
		this.cittaDiResidenza = cittaDiResidenza;
	}

	public String getIndirizzoDiResidenza() {
		return indirizzoDiResidenza;
	}

	public void setIndirizzoDiResidenza(String indirizzoDiResidenza) {
		this.indirizzoDiResidenza = indirizzoDiResidenza;
	}

	public int getCapDiResidenza() {
		return capDiResidenza;
	}

	public void setCapDiResidenza(int capDiResidenza) {
		this.capDiResidenza = capDiResidenza;
	}

	public void setAnagrafica(JSONObject anagrafica) {
		this.nome = (String)anagrafica.get("nome");
		this.cognome = (String)anagrafica.get("cognome");
		this.cellulare = (String)anagrafica.get("cellulare");
		this.email = (String)anagrafica.get("email");
		this.cittaDiResidenza = (String)anagrafica.get("citta");
	}
}