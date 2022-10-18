package it.teorema.gestech.model.mapper;

import java.time.LocalDateTime;

public interface AllRichieste {
	int getId();
	LocalDateTime getData();
	String getCliente();
	String getCitta();
	double getCosto();
	String getNote();
	String getLinguaggiNome();
	String getProfiliNome();
	String getLivelliNome();
	String getStatiRichiesteNome();
	int getPriorita();
	String getRecruiters();
}
