package it.teorema.gestech.model.mapper;

import java.time.LocalDate;

public interface AllStoriciBeni {
	int getid();
	String getNome();
	String getCognome();
	LocalDate getDataConsegna();
	LocalDate getDataRestituzione();
}
