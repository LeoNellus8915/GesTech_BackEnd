package it.teorema.gestech.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sy_dipendenti")
public class Dipendenti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nome_cognome")
	private String nomeCognome;
	@Column(name = "codice_fiscale")
	private String codiceFiscale;
	@Column(name = "email")
	private String email;
	@Column(name = "cellulare")
	private String cellulare;
	@Column(name = "residenza")
	private String residenza;
	@Column(name = "domicilio")
	private String domicilio;
	@Column(name = "data_di_nascita")
	private LocalDate dataDiNascita;
	@Column(name = "luogo_di_nascita")
	private String luogoDiNascita;
	
	public Dipendenti() {}

	public Dipendenti(int id, String nomeCognome, String codiceFiscale, String email, String cellulare,
			String residenza, String domicilio, LocalDate dataDiNascita, String luogoDiNascita) {
		super();
		this.id = id;
		this.nomeCognome = nomeCognome;
		this.codiceFiscale = codiceFiscale;
		this.email = email;
		this.cellulare = cellulare;
		this.residenza = residenza;
		this.domicilio = domicilio;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
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

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
}
