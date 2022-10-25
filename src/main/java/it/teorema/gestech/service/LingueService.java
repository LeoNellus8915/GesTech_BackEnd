package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Lingue;

public interface LingueService extends JpaRepository <Lingue, Integer> {
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliCandidati dc, LingueDettagliCandidati ldc "
			+ "where l.id = ldc.idLingua and dc.idPersona = :idPersona")
	String[] getLingua(int idPersona);

	@Query("from Lingue "
			+ "where nome != :lingua")
	List<Lingue> findAllException(String lingua);
}