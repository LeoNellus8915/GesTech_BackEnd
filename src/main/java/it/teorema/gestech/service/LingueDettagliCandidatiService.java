package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.LingueDettagliCandidati;
import it.teorema.gestech.model.mapper.InfoLingue;

public interface LingueDettagliCandidatiService extends JpaRepository <LingueDettagliCandidati, Integer> {

	@Query("select l.nome as nomeLingua "
			+ "from Lingue l, DettagliCandidati dc, LingueDettagliCandidati ldc "
			+ "where l.id = ldc.idLingua and dc.id = ldc.idDettaglioCandidato and dc.idPersona = :idCandidato")
	String[] getLingue(int idCandidato);
	
	@Query("select ldc.id as idLingua, ldc.descrizione as descrizione "
			+ "from DettagliCandidati dc, LingueDettagliCandidati ldc "
			+ "where dc.idPersona = :idCandidato and ldc.idDettaglioCandidato = dc.id")
	List<InfoLingue> getInfoLingue(int idCandidato);
}