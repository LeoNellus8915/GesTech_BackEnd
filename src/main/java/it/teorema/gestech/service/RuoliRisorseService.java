package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.RuoliRisorse;

public interface RuoliRisorseService extends JpaRepository <RuoliRisorse, Integer>{
	@Query("select r.nome "
			+ "from RuoliRisorse rr, Ruoli r "
			+ "where rr.idRuolo = r.id and rr.idRisorsa = :idRisorsa")
	List<String> getRuoloByIdRisorsa(int idRisorsa);
	
	@Query("select r.nome "
			+ "from RuoliRisorse rr, Ruoli r "
			+ "where rr.idRuolo = r.id and rr.idRisorsa = :idRisorsa and r.nome != 'Dipendente'")
	String getSecondoRuoloByIdRisorsa(int idRisorsa);
}