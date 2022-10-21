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
@Table(name="am_hardware")
public class Hardware {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "id_dispositivo")
	private int idDispositivo;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "seriale")
	private String seriale;
	@Column(name = "data_consegna")
	private LocalDate dataConsegna;
	@Column(name = "data_restituzione")
	private LocalDate dataRestituzione;
	@Column(name = "note")
	private String note;
	
	public Hardware() {}
	
	public Hardware(int idDispositivo, String marca, String modello, String seriale) {
		super();
		this.idPersona = 10;
		this.idDispositivo = idDispositivo;
		this.marca = marca;
		this.modello = modello;
		this.seriale = seriale;
	}
	
	public Hardware(int idPersona, int idDispositivo, String marca, String modello, String seriale, LocalDate dataConsegna,
			LocalDate dataRestituzione, String note) {
		super();
		this.idPersona = idPersona;
		this.idDispositivo = idDispositivo;
		this.marca = marca;
		this.modello = modello;
		this.seriale = seriale;
		this.dataConsegna = dataConsegna;
		this.dataRestituzione = dataRestituzione;
		this.note = note;
	}

	public Hardware(int id, int idPersona, int idDispositivo, String marca, String modello, String seriale, LocalDate dataConsegna,
			LocalDate dataRestituzione, String note) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.idDispositivo = idDispositivo;
		this.marca = marca;
		this.modello = modello;
		this.seriale = seriale;
		this.dataConsegna = dataConsegna;
		this.dataRestituzione = dataRestituzione;
		this.note = note;
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

	public int getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
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

	public String getSeriale() {
		return seriale;
	}

	public void setSeriale(String seriale) {
		this.seriale = seriale;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
//	public Hardware setUpdateHardware(JSONObject form,int id) {
//		Hardware updateHardware = new Hardware();
//		
//		updateHardware.setId(id);
//		updateHardware.setIdDispositivo(Integer.parseInt(form.con));
//		
//		return null;
//	}
}