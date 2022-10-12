package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hs_cv")
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "file_cv_base64")
	private String cvBase64;
	@Column(name = "data")
	private LocalDateTime data;
	
	public Cv() {}

	public Cv(int id, int idPersona, String cvBase64, LocalDateTime data) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.cvBase64 = cvBase64;
		this.data = data;
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

	public String getCvBase64() {
		return cvBase64;
	}

	public void setCvBase64(String cvBase64) {
		this.cvBase64 = cvBase64;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	

}
