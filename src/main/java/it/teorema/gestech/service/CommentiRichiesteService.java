package it.teorema.gestech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.teorema.gestech.model.CommentiRichieste;
import it.teorema.gestech.model.mapper.AllCommentiRichieste;

public interface CommentiRichiesteService extends JpaRepository <CommentiRichieste, Integer> {
	
	@Query("select c.data as data, p.nome as nome, p.cognome as cognome, c.note as note "
			+ "from CommentiRichieste c, Persone p "
			+ "where c.idRichiesta = :idRichiesta and c.idPersona = p.id and c.nascosto = 1 "
			+ "order by c.data desc")
	List<AllCommentiRichieste> findById(int idRichiesta);
	
	@Query("select c.data as data, p.nome as nome, p.cognome as cognome, c.note as note "
			+ "from CommentiRichieste c, Persone p "
			+ "where c.idRichiesta = :idRichiesta and c.idPersona = p.id "
			+ "order by c.data desc")
	List<AllCommentiRichieste> findRecruiterById(int idRichiesta);
	
	@Query("select c.data as data, p.nome as nome, p.cognome as cognome, c.note as note "
			+ "from CommentiRichieste c, Persone p "
			+ "where c.idRichiesta = :idRichiesta and c.idPersona = p.id and c.nascosto = 0 "
			+ "order by c.data desc")
	List<AllCommentiRichieste> findAltriById(int idRichiesta);

	@Modifying
	@Transactional
	@Query("delete "
			+ "from CommentiRichieste "
			+ "where idRichiesta = :idRichiesta")
	void deleteCommento(int idRichiesta);

	@Query("select r.recruiter "
			+ "from Richieste r "
			+ "where r.id = :idRichiesta "
			+ "group by r.id")
	String recruiterPresente(int idRichiesta);
}