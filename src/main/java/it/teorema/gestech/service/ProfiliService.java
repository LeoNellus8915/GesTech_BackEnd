package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Profili;

public interface ProfiliService extends JpaRepository <Profili, Integer> {
	@Query("select p.nome "
			+ "from Profili p, DettagliRisorse d "
			+ "where d.idRisorsa = :idRisorsa and p.id = d.idProfilo")
	String getProfilo(int idRisorsa);

	@Query("from Profili "
			+ "where nome != :profilo")
	List<Profili> findAllException(String profilo);
}