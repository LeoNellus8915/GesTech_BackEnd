package it.teorema.gestech.model.mapper;

import java.time.LocalDateTime;

public interface GetRichiesta{
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
	String getRecruiter();
	String getCandidati();
}
