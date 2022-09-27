package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.RuoliDipendenti;

public interface RuoliDipendentiService extends JpaRepository <RuoliDipendenti, Integer>{
	@Query("select r.nome "
			+ "from RuoliDipendenti rd, Ruoli r "
			+ "where rd.idRuolo = r.id and rd.idDipendente = :idDipendente")
	List<String> getRuoloByIdDipendente(int idDipendente);
	
	@Query("select r.nome "
			+ "from RuoliDipendenti rd, Ruoli r "
			+ "where rd.idRuolo = r.id and rd.idDipendente = :idDipendente and r.nome != 'Dipendente'")
	String getSecondoRuoloByIdDipendente(int idDipendente);
}