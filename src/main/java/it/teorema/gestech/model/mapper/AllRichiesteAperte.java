package it.teorema.gestech.model.mapper;

import java.time.LocalDateTime;

public interface AllRichiesteAperte {
	int getId();
	LocalDateTime getData();
	int getIdCliente();
	String getCitta();
	double getCosto();
	String getNote();
	String getLinguaggiNome();
	String getProfiliNome();
	String getLivelliNome();
	String getStatiRichiesteNome();
	int getPriorita();
	boolean getVisualizzato();
}
