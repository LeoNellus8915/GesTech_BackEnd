package it.teorema.gestech.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hr_contratti")
public class Contratti
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "id_persona")
	private int idPersona;
	@Column(name = "id_tipo_contratto")
	private int idTipoContratto;
	@Column(name = "id_ccnl")
	private int idCCNL;
	@Column(name = "data_di_inizio")
	private LocalDate dataDiInizio;
	@Column(name = "data_di_fine")
	private LocalDate dataDiFine;
	@Column(name = "id_azienda")
	private int idAzienda;
	@Column(name = "periodo_di_prova")
	private int periodoDiProva;
	@Column(name = "ral")
	private int ral;
	
	
	public Contratti() {}


	public Contratti(int id, int idPersona, int idTipoContratto, int idCCNL, LocalDate dataDiInizio,
			LocalDate dataDiFine, int idAzienda, int periodoDiProva, int ral) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.idTipoContratto = idTipoContratto;
		this.idCCNL = idCCNL;
		this.dataDiInizio = dataDiInizio;
		this.dataDiFine = dataDiFine;
		this.idAzienda = idAzienda;
		this.periodoDiProva = periodoDiProva;
		this.ral = ral;
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


	public int getIdTipoContratto() {
		return idTipoContratto;
	}


	public void setIdTipoContratto(int idTipoContratto) {
		this.idTipoContratto = idTipoContratto;
	}


	public int getIdCCNL() {
		return idCCNL;
	}


	public void setIdCCNL(int idCCNL) {
		this.idCCNL = idCCNL;
	}


	public LocalDate getDataDiInizio() {
		return dataDiInizio;
	}


	public void setDataDiInizio(LocalDate dataDiInizio) {
		this.dataDiInizio = dataDiInizio;
	}


	public LocalDate getDataDiFine() {
		return dataDiFine;
	}


	public void setDataDiFine(LocalDate dataDiFine) {
		this.dataDiFine = dataDiFine;
	}


	public int getIdAzienda() {
		return idAzienda;
	}


	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}


	public int getPeriodoDiProva() {
		return periodoDiProva;
	}


	public void setPeriodoDiProva(int periodoDiProva) {
		this.periodoDiProva = periodoDiProva;
	}


	public int getRal() {
		return ral;
	}


	public void setRal(int ral) {
		this.ral = ral;
	}
	
	
}