package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.LingueDettagliCandidati;
import it.teorema.gestech.model.mapper.InfoLingue;

public interface LingueDettagliCandidatiService extends JpaRepository <LingueDettagliCandidati, Integer> {

	@Query("select l.nome as nomeLingua "
			+ "from Lingue l, DettagliCandidati dc, LingueDettagliCandidati ldc "
			+ "where l.id = ldc.idLingua and dc.id = ldc.idDettaglioCandidato and dc.idPersona = :idCandidato")
	String[] getLingue(int idCandidato);
	
	@Query("select l.id as idLingua, l.nome as nomeLingua, ldc.descrizione as descrizione "
			+ "from DettagliCandidati dc, LingueDettagliCandidati ldc, Lingue l "
			+ "where dc.idPersona = :idCandidato and ldc.idDettaglioCandidato = dc.id and ldc.idLingua = l.id")
	List<InfoLingue> getInfoLingue(int idCandidato);
	
	@Modifying
	@Transactional
	@Query("delete "
			+ "from LingueDettagliCandidati ldc "
			+ "where ldc.idDettaglioCandidato = :idDettaglioCandidato")
	void deleteByIdDettaglioCandidato(int idDettaglioCandidato);
}