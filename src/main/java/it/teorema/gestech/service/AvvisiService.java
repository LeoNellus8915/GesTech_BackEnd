package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Avvisi;

public interface AvvisiService extends JpaRepository <Avvisi, Integer> {	
	@Query("from Avvisi order by data desc")
	List<Avvisi> findAll();

	@Query("from Avvisi "
			+ "where ruoli like '%Tutti%' or ruoli like %:ruolo% order by data desc")
	List<Avvisi> getAvvisiByRuolo(String ruolo);
}