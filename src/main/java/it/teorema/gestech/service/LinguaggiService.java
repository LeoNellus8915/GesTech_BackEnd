package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Linguaggi;

public interface LinguaggiService extends JpaRepository <Linguaggi, Integer> {	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliCandidati dc "
			+ "where l.id = dc.idLinguaggio1 and dc.idCandidato = :idCandidato")
	String getLinguaggio1(int idCandidato);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliCandidati dc "
			+ "where l.id = dc.idLinguaggio2 and dc.idCandidato = :idCandidato")
	String getLinguaggio2(int idCandidato);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliCandidati dc "
			+ "where l.id = dc.idLinguaggio3 and dc.idCandidato = :idCandidato")
	String getLinguaggio3(int idCandidato);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliCandidati dc "
			+ "where l.id = dc.idLinguaggio4 and dc.idCandidato = :idCandidato")
	String getLinguaggio4(int idCandidato);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliCandidati dc "
			+ "where l.id = dc.idLinguaggio5 and dc.idCandidato = :idCandidato")
	String getLinguaggio5(int idCandidato);

	@Query("from Linguaggi "
			+ "where nome != :skill")
	List<Linguaggi> findAllException(String skill);
}