package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Lingue;

public interface LingueService extends JpaRepository <Lingue, Integer> {	
	@Query("select l.nome "
			+ "from Lingue l, DettagliRisorse d "
			+ "where l.id = d.idLingua1 and d.idRisorsa = :idRisorsa")
	String getLingua1(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliRisorse d "
			+ "where l.id = d.idLingua2 and d.idRisorsa = :idRisorsa")
	String getLingua2(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Lingue l, DettagliRisorse d "
			+ "where l.id = d.idLingua3 and d.idRisorsa = :idRisorsa")
	String getLingua3(int idRisorsa);

	@Query("from Lingue "
			+ "where nome != :lingua")
	List<Lingue> findAllException(String lingua);
}