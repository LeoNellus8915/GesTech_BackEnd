package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Lingue;

public interface LingueService extends JpaRepository <Lingue, Integer> {	
	@Query("select l.nome "
			+ "from Lingue l, DettagliCandidati dc "
			+ "where l.id = dc.idLingua1 and dc.idCandidato = :idCandidato")
	String getLingua1(int idCandidato);
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliCandidati dc "
			+ "where l.id = dc.idLingua2 and dc.idCandidato = :idCandidato")
	String getLingua2(int idCandidato);
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliCandidati dc "
			+ "where l.id = dc.idLingua3 and dc.idCandidato = :idCandidato")
	String getLingua3(int idCandidato);

	@Query("from Lingue "
			+ "where nome != :lingua")
	List<Lingue> findAllException(String lingua);
}