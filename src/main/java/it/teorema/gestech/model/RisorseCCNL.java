package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_risorse_ccnl")
public class RisorseCCNL
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_risorsa")
	private int idRisorsa;
	@Column(name = "data_download")
	private LocalDateTime dataDownload;
	
	public RisorseCCNL() {}

	public RisorseCCNL(int id, int idRisorsa, LocalDateTime dataDownload) {
		super();
		this.id = id;
		this.idRisorsa = idRisorsa;
		this.dataDownload = dataDownload;
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

	public LocalDateTime getDataDownload() {
		return dataDownload;
	}

	public void setDataDownload(LocalDateTime dataDownload) {
		this.dataDownload = dataDownload;
	}
}