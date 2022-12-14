package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Ruoli;

public interface RuoliService extends JpaRepository <Ruoli, Integer> {

	@Query("from Ruoli where nome != 'Dipendente'")
	List<Ruoli> allRuoliTranneDipendenteAdmin();
	
	@Query("from Ruoli where nome != 'Dipendente' and nome != 'Admin'")
	List<Ruoli> allRuoliTranneDipendentePersonale();
}