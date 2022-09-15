package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.AziendeRisorse;

public interface AziendeRisorseService extends JpaRepository <AziendeRisorse, Integer> {
	@Query("select a.nome "
			+ "from AziendeRisorse ar, Aziende a "
			+ "where ar.idAzienda = a.id and ar.idRisorsa = :idRisorsa")
	String getAziendaByIdRisorsa(int idRisorsa);
}