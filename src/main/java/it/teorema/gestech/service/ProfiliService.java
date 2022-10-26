package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Profili;

public interface ProfiliService extends JpaRepository <Profili, Integer> {
	
	@Query("select p.nome "
			+ "from Profili p, DettagliCandidati dc, ProfiliDettagliCandidati pdc "
			+ "where dc.idPersona = :idPersona and p.id = pdc.idProfilo and pdc.idDettaglioCandidato = dc.id ")
	String getProfilo(int idPersona);

	@Query("from Profili "
			+ "where nome != :profilo")
	List<Profili> findAllException(String profilo);
}