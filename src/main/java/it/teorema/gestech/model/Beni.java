package it.teorema.gestech.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sy_beni")
public class Beni
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "dispositivo")
	private String dispositivo;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "numero_seriale")
	private String numeroSeriale;
	@Column(name = "password")
	private String password;
	@Column(name = "note")
	private String note;
	@Column(name = "dipendente")
	private String dipendente;
	@Column(name = "societa")
	private String societa;
	@Column(name = "data_consegna")
	private LocalDate dataConsegna;
	@Column(name = "data_restituzione")
	private LocalDate dataRestituzione;
	
	public Beni() {}

	public Beni(int id, String dispositivo, String marca, String modello, String numeroSeriale, String password,
			String note, String dipendente, String societa, LocalDate dataConsegna,
			LocalDate dataRestituzione) {
		super();
		this.id = id;
		this.dispositivo = dispositivo;
		this.marca = marca;
		this.modello = modello;
		this.numeroSeriale = numeroSeriale;
		this.password = password;
		this.note = note;
		this.dipendente = dipendente;
		this.societa = societa;
		this.dataConsegna = dataConsegna;
		this.dataRestituzione = dataRestituzione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getNumeroSeriale() {
		return numeroSeriale;
	}

	public void setNumeroSeriale(String numeroSeriale) {
		this.numeroSeriale = numeroSeriale;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDipendente() {
		return dipendente;
	}

	public void setDipendente(String dipendente) {
		this.dipendente = dipendente;
	}

	public String getSocieta() {
		return societa;
	}

	public void setSocieta(String societa) {
		this.societa = societa;
	}

	public LocalDate getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(LocalDate dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public LocalDate getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(LocalDate dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}
}
