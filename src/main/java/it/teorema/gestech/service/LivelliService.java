package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Livelli;

public interface LivelliService extends JpaRepository <Livelli, Integer> {	
	@Query("select l.nome "
			+ "from Livelli l, DettagliRisorse d "
			+ "where l.id = d.idSeniority and d.idRisorsa = :idRisorsa")
	String getSeniority(int idRisorsa);
	
	@Query("from Livelli "
			+ "where nome != :seniority")
	List<Livelli> findAllException(String seniority);
}