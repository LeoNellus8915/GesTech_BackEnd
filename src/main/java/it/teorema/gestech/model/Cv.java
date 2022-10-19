package it.teorema.gestech.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.simple.JSONObject;

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
	
	public void setCv(JSONObject cv, int idCandidato) {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		LocalDateTime data = LocalDateTime.parse(format1.format(now), format1);
		
		this.idPersona = idCandidato;
		this.data = data;
		if ((String)cv.get("cv") == null)
			this.setCvBase64(null);
		else
			this.setCvBase64((String)cv.get("cv").toString());
	}
}
