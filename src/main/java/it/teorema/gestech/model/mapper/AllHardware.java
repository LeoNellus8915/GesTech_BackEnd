package it.teorema.gestech.model.mapper;

import java.time.LocalDate;

public interface AllHardware {
	int getId();
	String getNomePersona();
	String getCognomePersona();
	String getNomeDispositivo();
	String getModello();
	String getMarca();
	String getNote();
	String getSeriale();
	LocalDate getDataConsegna();
	LocalDate getDataRestituzione();
}