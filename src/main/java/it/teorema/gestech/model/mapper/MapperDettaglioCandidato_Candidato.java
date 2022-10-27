package it.teorema.gestech.model.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface MapperDettaglioCandidato_Candidato {
	
	String getEsitoColloquio();
	LocalDateTime getDatainserimento();
	String getCompetenzaPrincipale();
	LocalDate getDataColloquio();
	int getAnnoColloquio();
	String getFonteReperimento();
	double getConstoGiornaliero();
	String getPossibilitaLavorativa();
	String getCompetenzaTotali();
	String getCertificazioni();
	
}
