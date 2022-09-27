package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Livelli;

public interface LivelliService extends JpaRepository <Livelli, Integer> {	
	@Query("select l.nome "
			+ "from Livelli l, DettagliCandidati dc "
			+ "where l.id = dc.idLivello and dc.idCandidato = :idCandidato")
	String getSeniority(int idCandidato);
	
	@Query("from Livelli "
			+ "where nome != :seniority")
	List<Livelli> findAllException(String seniority);
}