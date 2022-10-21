package it.teorema.gestech.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.LingueDettagliCandidati;

public interface LingueDettagliCandidatiService extends JpaRepository <LingueDettagliCandidati, Integer> {

	@Query("select l.nome as nomeLingua "
			+ "from Lingue l, DettagliCandidati dc, LingueDettagliCandidati ldc "
			+ "where l.id = ldc.idLingua and dc.id = ldc.idDettaglioCandidato and dc.idPersona = :idCandidato")
	String[] getLingue(int idCandidato);
}