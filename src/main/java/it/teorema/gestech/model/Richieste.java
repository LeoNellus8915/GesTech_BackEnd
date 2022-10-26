package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="am_richieste")
public class Richieste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "data")
	private LocalDateTime data;
	@Column(name = "id_linguaggio")
	private int idLinguaggio;
	@Column(name = "id_profilo")
	private int idProfilo;
	@Column(name = "id_livello")
	private int idLivello;
	@Column(name = "id_Cliente")
	private int idCliente;
	@Column(name = "citta")
	private String citta;
	@Column(name = "costo")
	private double costo;
	@Column(name = "note")
	private String note;
	@Column(name = "recruiter")
	private String recruiter;
	@Column(name = "id_stato")
	private int idStato;
	@Column(name = "priorita")
	private int priorita;
	
	public Richieste() {}

	public Richieste(int id, String recruiter, int idStato, int priorita) {
		super();
		this.id = id;
		this.recruiter = recruiter;
		this.idStato = idStato;
		this.priorita = priorita;
	}



	public Richieste(int id, int idPersona, LocalDateTime data, int idLinguaggio, int idProfilo, int idLivello,
			int idCliente, String citta, double costo, String note, String recruiter, int idStato, int priorita,
			String candidati) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.data = data;
		this.idLinguaggio = idLinguaggio;
		this.idProfilo = idProfilo;
		this.idLivello = idLivello;
		this.idCliente = idCliente;
		this.citta = citta;
		this.costo = costo;
		this.note = note;
		this.recruiter = recruiter;
		this.idStato = idStato;
		this.priorita = priorita;
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getIdLinguaggio() {
		return idLinguaggio;
	}

	public void setIdLinguaggio(int idLinguaggio) {
		this.idLinguaggio = idLinguaggio;
	}

	public int getIdProfilo() {
		return idProfilo;
	}

	public void setIdProfilo(int idProfilo) {
		this.idProfilo = idProfilo;
	}

	public int getIdLivello() {
		return idLivello;
	}

	public void setIdLivello(int idLivello) {
		this.idLivello = idLivello;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public int getIdStato() {
		return idStato;
	}

	public void setIdStato(int idStato) {
		this.idStato = idStato;
	}

	public int getPriorita() {
		return priorita;
	}

	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}
}