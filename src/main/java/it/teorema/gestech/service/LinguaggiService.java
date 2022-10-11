package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Linguaggi;

public interface LinguaggiService extends JpaRepository <Linguaggi, Integer> {	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliCandidati dc, ProfiliDettagliCandidati pdc "
			+ "where l.id = pdc.idLinguaggio and pdc.idDettaglioCandidato = dc.id and dc.idPersona = :idPersona")
	String[] getLinguaggio(int idPersona);

	@Query("from Linguaggi "
			+ "where nome != :linguaggio")
	List<Linguaggi> findAllException(String linguaggio);
}