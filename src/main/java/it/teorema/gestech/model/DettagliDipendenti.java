package it.teorema.gestech.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hy_dettagli_dipendenti")
public class DettagliDipendenti
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "file_base64")
	private String fileBase64;
	@Column(name = "data_assunzione")
	private LocalDate dataAssunzione;
	@Column(name = "data_fine_rapporto")
	private LocalDate dataFineRapporto;
	@Column(name = "id_azienda")
	private int idAzienda;
	@Column(name = "id_contratto")
	private int idContratto;
	@Column(name = "id_livello_contratto")
	private int idLivelloContratto;
	@Column(name = "id_mansione")
	private int idMansione;
	@Column(name = "id_cliente")
	private int idCliente;
	@Column(name = "id_periodo_di_prova")
	private int idPeriodoDiProva;
	@Column(name = "id_periodo_di_preavviso")
	private int idPeriodoDiPreavviso;
	
	public DettagliDipendenti() {}

	public DettagliDipendenti(int id, String fileBase64, LocalDate dataAssunzione, LocalDate dataFineRapporto,
			int idAzienda, int idContratto, int idLivelloContratto, int idMansione, int idCliente, int idPeriodoDiProva,
			int idPeriodoDiPreavviso) {
		super();
		this.id = id;
		this.fileBase64 = fileBase64;
		this.dataAssunzione = dataAssunzione;
		this.dataFineRapporto = dataFineRapporto;
		this.idAzienda = idAzienda;
		this.idContratto = idContratto;
		this.idLivelloContratto = idLivelloContratto;
		this.idMansione = idMansione;
		this.idCliente = idCliente;
		this.idPeriodoDiProva = idPeriodoDiProva;
		this.idPeriodoDiPreavviso = idPeriodoDiPreavviso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileBase64() {
		return fileBase64;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public LocalDate getDataFineRapporto() {
		return dataFineRapporto;
	}

	public void setDataFineRapporto(LocalDate dataFineRapporto) {
		this.dataFineRapporto = dataFineRapporto;
	}

	public int getIdAzienda() {
		return idAzienda;
	}

	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}

	public int getIdContratto() {
		return idContratto;
	}

	public void setIdContratto(int idContratto) {
		this.idContratto = idContratto;
	}

	public int getIdLivelloContratto() {
		return idLivelloContratto;
	}

	public void setIdLivelloContratto(int idLivelloContratto) {
		this.idLivelloContratto = idLivelloContratto;
	}

	public int getIdMansione() {
		return idMansione;
	}

	public void setIdMansione(int idMansione) {
		this.idMansione = idMansione;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdPeriodoDiProva() {
		return idPeriodoDiProva;
	}

	public void setIdPeriodoDiProva(int idPeriodoDiProva) {
		this.idPeriodoDiProva = idPeriodoDiProva;
	}

	public int getIdPeriodoDiPreavviso() {
		return idPeriodoDiPreavviso;
	}

	public void setIdPeriodoDiPreavviso(int idPeriodoDiPreavviso) {
		this.idPeriodoDiPreavviso = idPeriodoDiPreavviso;
	}
}