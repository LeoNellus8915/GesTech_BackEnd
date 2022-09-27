package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Profili;

public interface ProfiliService extends JpaRepository <Profili, Integer> {
	@Query("select p.nome "
			+ "from Profili p, DettagliCandidati dc "
			+ "where dc.idCandidato = :idCandidato and p.id = dc.idProfilo")
	String getProfilo(int idCandidato);

	@Query("from Profili "
			+ "where nome != :profilo")
	List<Profili> findAllException(String profilo);
}