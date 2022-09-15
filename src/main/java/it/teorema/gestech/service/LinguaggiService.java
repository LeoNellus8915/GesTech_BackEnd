package it.teorema.gestech.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.Linguaggi;

public interface LinguaggiService extends JpaRepository <Linguaggi, Integer> {	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill1 and d.idRisorsa = :idRisorsa")
	String getSkill1(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill2 and d.idRisorsa = :idRisorsa")
	String getSkill2(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill3 and d.idRisorsa = :idRisorsa")
	String getSkill3(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill4 and d.idRisorsa = :idRisorsa")
	String getSkill4(int idRisorsa);
	
	@Query("select l.nome "
			+ "from Linguaggi l, DettagliRisorse d "
			+ "where l.id = d.idSkill5 and d.idRisorsa = :idRisorsa")
	String getSkill5(int idRisorsa);

	@Query("from Linguaggi "
			+ "where nome != :skill")
	List<Linguaggi> findAllException(String skill);
}