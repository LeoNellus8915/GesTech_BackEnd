package it.teorema.gestech.model.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface InfoDettaglioCandidato {
	
	String getProfiloLinkedin();
	int getIdEsitoColloquio();
	String getEsitoColloquio();
	int getColoreEsitoColloquio();
	LocalDateTime getDataInserimento();
	String getCompetenzaPrincipale();
	LocalDate getDataColloquio();
	Integer getAnnoColloquio();
	String getFonteReperimento();
	Double getConstoGiornaliero();
	String getPossibilitaLavorativa();
	String getCompetenzaTotali();
	String getCertificazioni();
	
}