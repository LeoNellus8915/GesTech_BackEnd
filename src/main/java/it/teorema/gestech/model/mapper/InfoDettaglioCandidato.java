package it.teorema.gestech.model.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InfoDettaglioCandidato {
	
	String profiloLinkedin;
	int idEsitoColloquio;
	String esitoColloquio;
	int coloreEsitoColloquio;
	LocalDateTime dataInserimento;
	String competenzaPrincipale;
	LocalDate dataColloquio;
	Integer annoColloquio;
	String fonteReperimento;
	Double costoGiornaliero;
	String possibilitaLavorativa;
	String competenzeTotali;
	String certificazioni;
	
	public InfoDettaglioCandidato() {}
	
	public InfoDettaglioCandidato(String profiloLinkedin, int idEsitoColloquio, String esitoColloquio,
			int coloreEsitoColloquio, LocalDateTime dataInserimento, String competenzaPrincipale,
			LocalDate dataColloquio, Integer annoColloquio, String fonteReperimento, Double costoGiornaliero,
			String possibilitaLavorativa, String competenzeTotali, String certificazioni) {
		super();
		this.profiloLinkedin = profiloLinkedin;
		this.idEsitoColloquio = idEsitoColloquio;
		this.esitoColloquio = esitoColloquio;
		this.coloreEsitoColloquio = coloreEsitoColloquio;
		this.dataInserimento = dataInserimento;
		this.competenzaPrincipale = competenzaPrincipale;
		this.dataColloquio = dataColloquio;
		this.annoColloquio = annoColloquio;
		this.fonteReperimento = fonteReperimento;
		this.costoGiornaliero = costoGiornaliero;
		this.possibilitaLavorativa = possibilitaLavorativa;
		this.competenzeTotali = competenzeTotali;
		this.certificazioni = certificazioni;
	}

	public String getProfiloLinkedin() {
		return profiloLinkedin;
	}

	public void setProfiloLinkedin(String profiloLinkedin) {
		this.profiloLinkedin = profiloLinkedin;
	}

	public int getIdEsitoColloquio() {
		return idEsitoColloquio;
	}

	public void setIdEsitoColloquio(int idEsitoColloquio) {
		this.idEsitoColloquio = idEsitoColloquio;
	}

	public String getEsitoColloquio() {
		return esitoColloquio;
	}

	public void setEsitoColloquio(String esitoColloquio) {
		this.esitoColloquio = esitoColloquio;
	}

	public int getColoreEsitoColloquio() {
		return coloreEsitoColloquio;
	}

	public void setColoreEsitoColloquio(int coloreEsitoColloquio) {
		this.coloreEsitoColloquio = coloreEsitoColloquio;
	}

	public LocalDateTime getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDateTime dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getCompetenzaPrincipale() {
		return competenzaPrincipale;
	}

	public void setCompetenzaPrincipale(String competenzaPrincipale) {
		this.competenzaPrincipale = competenzaPrincipale;
	}

	public LocalDate getDataColloquio() {
		return dataColloquio;
	}

	public void setDataColloquio(LocalDate dataColloquio) {
		this.dataColloquio = dataColloquio;
	}

	public Integer getAnnoColloquio() {
		return annoColloquio;
	}

	public void setAnnoColloquio(Integer annoColloquio) {
		this.annoColloquio = annoColloquio;
	}

	public String getFonteReperimento() {
		return fonteReperimento;
	}

	public void setFonteReperimento(String fonteReperimento) {
		this.fonteReperimento = fonteReperimento;
	}

	public Double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public void setCostoGiornaliero(Double costoGiornaliero) {
		this.costoGiornaliero = costoGiornaliero;
	}

	public String getPossibilitaLavorativa() {
		return possibilitaLavorativa;
	}

	public void setPossibilitaLavorativa(String possibilitaLavorativa) {
		this.possibilitaLavorativa = possibilitaLavorativa;
	}

	public String getCompetenzeTotali() {
		return competenzeTotali;
	}

	public void setCompetenzeTotali(String competenzeTotali) {
		this.competenzeTotali = competenzeTotali;
	}

	public String getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(String certificazioni) {
		this.certificazioni = certificazioni;
	}
	
	
}