package it.teorema.gestech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_dipendenti_ccnl")
public class DipendentiCCNL
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_dipendente")
	private int idDipendente;
	@Column(name = "data_download")
	private LocalDateTime dataDownload;
	
	public DipendentiCCNL() {}

	public DipendentiCCNL(int id, int idDipendente, LocalDateTime dataDownload) {
		super();
		this.id = id;
		this.idDipendente = idDipendente;
		this.dataDownload = dataDownload;
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

	public LocalDateTime getDataDownload() {
		return dataDownload;
	}

	public void setDataDownload(LocalDateTime dataDownload) {
		this.dataDownload = dataDownload;
	}
}