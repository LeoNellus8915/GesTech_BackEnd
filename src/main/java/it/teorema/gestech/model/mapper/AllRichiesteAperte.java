package it.teorema.gestech.model.mapper;

import java.time.LocalDateTime;

public interface AllRichiesteAperte {
	int getId();
	LocalDateTime getData();
	String getCliente();
	String getCitta();
	double getCosto();
	String getNote();
	String getLinguaggiNome();
	String getProfiliNome();
	String getLivelliNome();
	String getStatiRichiestaNome();
	int getPriorita();
	boolean getVisualizzato();
}
